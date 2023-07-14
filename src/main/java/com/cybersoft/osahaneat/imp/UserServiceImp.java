package com.cybersoft.osahaneat.imp;

import com.cybersoft.osahaneat.dto.UserDTO;
import com.cybersoft.osahaneat.request.UserRequest;

import java.util.List;

public interface UserServiceImp {
    List<UserDTO> userDtoList ();
    boolean deleteUser (int id);

    boolean updateUser (int id , UserRequest userRequest);
}
