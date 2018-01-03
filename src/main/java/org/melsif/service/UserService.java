package org.melsif.service;

import org.apache.log4j.Logger;
import org.melsif.model.User;
import org.melsif.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final Logger LOGGER = Logger.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByAccount_Username(username);
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
