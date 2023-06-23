package com.test.springreactor.jwt.service;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextService {

    Logger logger = LoggerFactory.getLogger(SecurityContextService.class);

    public String securityTest(HttpServletRequest httpServletRequest) {
        httpServletRequest.getContextPath();


        return null;
    }

}
