package com.cybersoft.osahaneat.security;

import com.cybersoft.osahaneat.entity.Users;
import com.cybersoft.osahaneat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


// custom lại user để query từ database
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
       if(username == null){
           throw new  UsernameNotFoundException  ( "Can not find " + username);
       }
       // có arraylist rỗng vì chưa có phân quyền , phaan quyền sẽ làm sau
       return  new User(username , users.getPassword(),new ArrayList<>());
    }
}
