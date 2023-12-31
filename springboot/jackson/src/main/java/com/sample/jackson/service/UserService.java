package com.sample.jackson.service;

import com.sample.jackson.mapper.UserMapper;
import com.sample.jackson.model.UserData;
import com.sample.jackson.persistence.User;
import com.sample.jackson.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserData getUser(String loginId, boolean type) {
        User user = userRepository.findByLoginId(loginId);
        UserData userData = userMapper.userToUserData(user);
        if(Objects.nonNull(userData) && userData.isInternalUser() == type) {
            return userData;
        }
        return null;
    }

    public UserData getUser(String loginId) {
        User user = userRepository.findByLoginId(loginId);
        return userMapper.userToUserData(user);
    }

    public List<UserData> getAllUsers(boolean type) {
        List<User> users;
        if(!type) {
            users = userRepository.findByIsInternalUser(type);
        } else {
            users = userRepository.findAll();
        }
        return userMapper.userToUserData(users);
    }

    public UserData updateAddress(String loginId, UserData addressData, boolean type) {
        User user = userRepository.findByLoginId(loginId);
        if(Objects.nonNull(user) && user.isInternalUser() == type) {
            user.setAddress(addressData.getAddress());
        }
        if(Objects.nonNull(addressData.getCity())) {
            user.setCity(addressData.getCity());
        }
        if(Objects.nonNull(addressData.getSuburb())) {
            user.setSuburb(addressData.getSuburb());
        }
        return userMapper.userToUserData(user);
    }

    public UserData updateAddress(String loginId, UserData addressData) {
        User user = userRepository.findByLoginId(loginId);
        if(Objects.nonNull(user)) {
            if(Objects.nonNull(addressData.getAddress())) {
                user.setAddress(addressData.getAddress());
            }
            if(Objects.nonNull(addressData.getCity())) {
                user.setCity(addressData.getCity());
            }
            if(Objects.nonNull(addressData.getSuburb())) {
                user.setSuburb(addressData.getSuburb());
            }
            userRepository.save(user);
        }
        return userMapper.userToUserData(user);
    }

}
