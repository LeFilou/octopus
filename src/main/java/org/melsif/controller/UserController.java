package org.melsif.controller;

import org.melsif.dto.UserDto;
import org.melsif.service.UserService;
import org.melsif.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/api/user", produces = "application/json")
    public @ResponseBody UserDto getUserByUsername(@RequestParam(value="username") String username) {
        return userMapper.userToUserDto(userService.getUserByUsername(username));
    }
}
