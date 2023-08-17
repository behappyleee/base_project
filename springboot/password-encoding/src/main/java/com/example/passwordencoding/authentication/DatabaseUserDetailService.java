package com.example.passwordencoding.authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DatabaseUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserDetailMapper userDetailMapper;

    public DatabaseUserDetailService(UserRepository userRepository, UserDetailMapper userDetailMapper) {
        this.userRepository = userRepository;
        this.userDetailMapper = userDetailMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials userCredentials = userRepository.findByUsername(username);

        return userDetailMapper.toUserDetails(userCredentials);
    }




}
