package com.cybersoft.osahaneat.service;


import com.cybersoft.osahaneat.dto.UserDTO;
import com.cybersoft.osahaneat.entity.Users;
import com.cybersoft.osahaneat.imp.LoginServiceImp;
import com.cybersoft.osahaneat.repository.UserRepository;
import com.cybersoft.osahaneat.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// sử lí logic code thì ở đây

@Service
public class LoginService implements LoginServiceImp {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Cacheable("loginhome")
    @Override
    public List<UserDTO> getAllUser (){

        List<Users> usersList = userRepository.findAll();
        List<UserDTO> userDTOList  = new ArrayList<>();

        for (Users data : usersList){
            UserDTO userDTO = new UserDTO();

            userDTO.setId(data.getId());
            userDTO.setUsername(data.getUsername());
            userDTO.setPassword(data.getPassword());
            userDTO.setFullname(data.getFullname());

            userDTOList.add(userDTO);
        }
          return userDTOList;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        Users users = userRepository.findByUsername(username);
        if (users == null) {
            return false;
        }
//        String encodedPassword = users.getPassword();
        return passwordEncoder.matches(password, users.getPassword());
    }

    @Override
    public boolean signUp(SignUpRequest signUpRequest) {
        // lấy ra role_id vì bảng users chưa khóa ngoại
//        Roles roles = new Roles();
//        roles.setId(signUpRequest.getRoleId());

        Users users = new Users();
        users.setFullname(signUpRequest.getFullName());
        users.setUsername(signUpRequest.getUsername());
        // mã hóa Bcript trước khi lưu vào database
        String endCode = passwordEncoder.encode(signUpRequest.getPassword());
        users.setPassword(endCode);


//        users.setRoles(roles);

        try {
            // hàm có sẵn để insert
            // insert thành công thì trả về true
            userRepository.save(users);
            return true;
        }catch (Exception e){
            System.out.println("Cannot Signup");
        }
        return false;
    }
}
