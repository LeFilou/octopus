package org.melsif.controller;

import org.apache.log4j.Logger;
import org.melsif.dto.UserDto;
import org.melsif.service.UserService;
import org.melsif.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/api/user", produces = "application/json")
    public @ResponseBody UserDto getUserByUsername(Authentication authentication) {
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return userMapper.userToUserDto(userService.getUserByUsername(authentication.getName()));
        } else
            return null;
    }
}
