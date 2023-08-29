package com.sample.jackson.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.sample.jackson.model.UserData;
import com.sample.jackson.persistence.Views;
import com.sample.jackson.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal")
public class InternalUserController {

    private static final Logger logger = LoggerFactory.getLogger(InternalUserController.class);

    private final UserService userService;

    @GetMapping("/users")
    @JsonView(Views.InternalView.class)
    public ResponseEntity<List<UserData>> getAllUsers(@RequestParam(required = false) String loginId) {
        if(Objects.isNull(loginId)) {
            return ResponseEntity.ok().body(userService.getAllUsers(true));
        } else {
            return ResponseEntity.ok().body(List.of(userService.getUser(loginId)));
        }
    }

    @GetMapping("/userdetails")
    @JsonView(Views.UserSummary.class)
    public ResponseEntity<UserData> getUserSummary(@RequestParam String loginId) {
        return ResponseEntity.ok().body(userService.getUser(loginId));
    }

    @PatchMapping("/users")
    public ResponseEntity<UserData> updateAddress(@RequestParam String loginId
            , @RequestBody @JsonView(Views.PatchView.class) UserData addressData) {
        return ResponseEntity.ok().body(userService.updateAddress(loginId, addressData));
    }

}
