package com.test.springwebflux.jwt.service;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextService {

    Logger logger = LoggerFactory.getLogger(SecurityContextService.class);

    public String securityTest(HttpServletRequest req) {
// HttpServletRequest 객체는 servlet, filter 를 개발할 떄 자주 사용
//        logger.debug("HTTP SERVLET : {} " , req.getContextPath());
//        logger.debug("HTTP COOKIE : {} " ,req.getCookies());
//        logger.debug("HTTP SESSION : {} " , req.getServerPort());
        // WAS 간의 http session 공유 방법은 HttpServletRequest 에서 제공하는 HttpSession 객체를 사용하는 것 외에도
        // 다른 방법들이 있음
        //

        return null;
    }

}
