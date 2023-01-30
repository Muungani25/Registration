package com.example.registration.controller;

import com.example.registration.domain.User;
import com.example.registration.dto.SignInRequest;
import com.example.registration.dto.SignUpRequest;
import com.example.registration.service.authentication.AuthenticationService;
import com.example.registration.service.registration.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserRegistrationService userRegistrationService;
    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInRequest signInRequest) {
        return authenticationService.signInUser(signInRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpRequest signUpRequest) {
        return userRegistrationService.registerUser(signUpRequest);
    }
    @PostMapping("/user")
    public User returnUser(@RequestBody String username){
        log.info("user:{}",username);
        User user= userRegistrationService.returnUser(username);
        return user;
    }

    @PostConstruct
    public void initiateRoles(){

        userRegistrationService.initiateRoles();
    }
}
