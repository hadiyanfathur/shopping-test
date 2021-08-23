package com.hadiyan.btsshoppingapp.controller;

import com.hadiyan.btsshoppingapp.dto.LoginDto;
import com.hadiyan.btsshoppingapp.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hadiyan.btsshoppingapp.service.UserService;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/signup")
    public Object register(@RequestBody UserDto dto) {
        return service.register(dto);
    }

    @PostMapping("/signin")
    public Object login(@RequestBody LoginDto login) throws Exception {
        return service.login(login);
    }
}
