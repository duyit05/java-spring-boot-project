package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.entity.Users;
import com.cybersoft.osahaneat.imp.UserServiceImp;
import com.cybersoft.osahaneat.payload.ResponeDataRes;
import com.cybersoft.osahaneat.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("/alluser")
    public ResponseEntity <?> getAllUser (){
        return new ResponseEntity<>(userServiceImp.userDtoList(), HttpStatus.OK);
    }

    @PostMapping("/deleteuser/{id}")
    public ResponseEntity <?> deleteUser (@PathVariable int id){
        ResponeDataRes data = new ResponeDataRes();
        data.setData(userServiceImp.deleteUser(id) ? true : false);
        return new ResponseEntity<>(data,  HttpStatus.OK);
    }

    @PutMapping("/updateuser")
    public ResponseEntity <?> updateUser (@RequestParam int id , @RequestBody UserRequest userRequest){
        ResponeDataRes data = new ResponeDataRes();

        data.setData(userServiceImp.updateUser(id,userRequest) ? true : false);

        return new ResponseEntity<>(data , HttpStatus.OK);
    }
}
