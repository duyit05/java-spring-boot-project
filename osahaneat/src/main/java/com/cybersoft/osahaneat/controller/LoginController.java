package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.imp.LoginServiceImp;
import com.cybersoft.osahaneat.payload.ResponseDataUser;
import com.cybersoft.osahaneat.request.SignUpRequest;
import com.cybersoft.osahaneat.util.JwtUtilHelper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {

    // khởi tạo đối tượng không cần new
    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtUtilHelper jwtUtilHelper;

    @PostMapping ("/alluser")
    public ResponseEntity <?> getAllUser (){

        return new ResponseEntity<>(loginServiceImp.getAllUser(),HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin (@RequestParam String username , @RequestParam  String password){

        ResponseDataUser responseData = new ResponseDataUser();
        String token = jwtUtilHelper.generalToken(username);

        if(loginServiceImp.checkLogin(username , password)){
            responseData.setDesc("OK");
            responseData.setData(token);
            responseData.setIssucess(true);
        }else{
            responseData.setDesc("Not Ok");
            responseData.setIssucess(false);
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity signUpUser (@RequestBody SignUpRequest signUpRequest){
        ResponseDataUser responseData = new ResponseDataUser();
        responseData.setData(loginServiceImp.signUp(signUpRequest) ? true: false);
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

}
