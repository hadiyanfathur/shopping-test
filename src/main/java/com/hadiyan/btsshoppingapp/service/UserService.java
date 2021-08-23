package com.hadiyan.btsshoppingapp.service;

import com.hadiyan.btsshoppingapp.dto.LoginDto;
import com.hadiyan.btsshoppingapp.dto.UserDto;

public interface UserService {
    UserDto register (UserDto dto);
    Object login(LoginDto dto);
}
