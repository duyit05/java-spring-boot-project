package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.dto.UserDTO;
import com.cybersoft.osahaneat.entity.Roles;
import com.cybersoft.osahaneat.entity.Users;
import com.cybersoft.osahaneat.imp.UserServiceImp;
import com.cybersoft.osahaneat.repository.RoleRepository;
import com.cybersoft.osahaneat.repository.UserRepository;
import com.cybersoft.osahaneat.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Cacheable("userhome")
    @Override
    public List<UserDTO> userDtoList() {
        List<Users> usersList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
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
    public boolean deleteUser(int id) {
        System.out.println("123");
        if(id > 0){
            Users users = userRepository.getById(id);
            if(users != null){
                userRepository.delete(users);
                return true;
            }
        }
        System.out.println("456");
        return false;
    }

    @Override
    public boolean updateUser(int id, UserRequest userRequest) {
        if (userRequest != null) {
            Users u = userRepository.getById(id);

            if (u != null) {
                Roles roles = roleRepository.getById(userRequest.getRoleId());

                if (roles != null) {
                    u.setUsername(userRequest.getUsername());
                    u.setPassword(userRequest.getPassword());
                    u.setFullname(userRequest.getFullname());
                    u.setRoles(roles);

                    userRepository.save(u);
                    return true;
                }
            }
        }

        return false;

    }
}
