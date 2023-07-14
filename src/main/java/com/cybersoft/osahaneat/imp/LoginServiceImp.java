package com.cybersoft.osahaneat.imp;

import com.cybersoft.osahaneat.dto.UserDTO;
import com.cybersoft.osahaneat.request.SignUpRequest;

import java.util.List;

// định nghĩa phương thức cho class Service để gọi và sử dụng
public interface LoginServiceImp {
    List<UserDTO> getAllUser ();
    boolean checkLogin (String username , String password);

    // thêm 1 user
    // nhận vào 1 đối tượng SignUpRequest bởi vì class này đại diện cho dữ liêệu người dùng nhập
    boolean signUp (SignUpRequest signUpRequest);

}
