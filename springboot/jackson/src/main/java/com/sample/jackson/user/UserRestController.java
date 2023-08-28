package com.sample.jackson.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.sample.jackson.persistence.Views;
import com.sample.jackson.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal")
public class UserRestController {

    private final static Logger logger = LoggerFactory.getLogger(UserRestController.class);

    private final UserService userService;

    @GetMapping("/users")
    @JsonView(Views.InternalView.class)
    public ResponseEntity<List<UserData>> getAllUsers(@RequestParam(required = false) String loginId) {
        // TODO
        // Response Value 설정 해 주기 !!!
        if(Objects.isNull(loginId)) {
            return ResponseEntity.ok().body()
        } else {
            return ResponseEntity.ok().body(List.of());
        }
    }


}
