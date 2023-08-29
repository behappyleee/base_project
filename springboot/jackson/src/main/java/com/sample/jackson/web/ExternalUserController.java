package com.sample.jackson.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.sample.jackson.model.UserData;
import com.sample.jackson.persistence.Views;
import com.sample.jackson.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/external")
public class ExternalUserController {

    private static final Logger logger = LoggerFactory.getLogger(ExternalUserController.class);

    private final UserService userService;

    @GetMapping("/userdetails/all")
    @JsonView(Views.UserDetailedSummary.class)
    public ResponseEntity<UserData> getExtDetailUsers(@RequestParam String loginId) {
        return ResponseEntity.ok().body(userService.getUser(loginId, false));
    }

    @GetMapping("/userdetails")
    @JsonView(Views.UserSummary.class)
    public ResponseEntity<UserData> getExtUserSummary(@RequestParam String logindId) {
        return ResponseEntity.ok().body(userService.getUser(logindId, false));
    }

    @GetMapping("/users")
    @JsonView(Views.ExternalView.class)
    public ResponseEntity<List<UserData>> getExtUsers(@RequestParam(required = false) String loginId) {
        if(Objects.isNull(loginId)) {
            return ResponseEntity.ok().body(userService.getAllUsers(false));
        } else {
            return ResponseEntity.ok().body(List.of(userService.getUser(loginId, false)));
        }
    }

    @GetMapping("/users")
    public ResponseEntity<UserData> updateExtUserAddress(@RequestParam String loginId
            , @RequestBody @JsonView(Views.PatchView.class) UserData addressData) {
        return ResponseEntity.ok().body(userService.updateAddress(loginId, addressData, false));
    }

}
