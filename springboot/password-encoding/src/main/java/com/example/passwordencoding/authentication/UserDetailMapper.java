package com.example.passwordencoding.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper {

    Logger logger = LoggerFactory.getLogger(UserDetailMapper.class);

    UserDetails toUserDetails(UserCredentials userCredentials) {
        return User.withUsername(userCredentials.getPassword())
                .roles(userCredentials.getRoles().toArray(String[]::new))
                .build();
    }
}
