package com.example.passwordencoding.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DatabaseUserDetailPsswordService implements UserDetailsPasswordService {

    private Logger logger = LoggerFactory.getLogger(DatabaseUserDetailPsswordService.class);

    private final UserRepository userRepository;

    private final UserDetailMapper userDetailMapper;

    public DatabaseUserDetailPsswordService(UserRepository userRepository, UserDetailMapper userDetailMapper) {
        this.userRepository = userRepository;
        this.userDetailMapper = userDetailMapper;
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        UserCredentials userCredentials = userRepository.findByUsername(user.getUsername());

        logger.debug("DATA BASE USER DETAIL SERVICE DATA : {} " , userCredentials);

        userCredentials.setPassword(newPassword);

        return userDetailMapper.toUserDetails(userCredentials);
    }

}
