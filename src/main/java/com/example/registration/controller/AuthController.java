package com.example.registration.controller;

import com.example.registration.domain.User;

import com.example.registration.dto.RegisteredUser;
import com.example.registration.dto.SignInRequest;
import com.example.registration.dto.SignUpRequest;
import com.example.registration.repository.UserRepository;
import com.example.registration.service.login.UserLoginService;
import com.example.registration.service.registration.UserRegistrationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")

public class AuthController {
    private UserRegistrationService userRegistrationService;
    private UserLoginService userLoginService;


    public AuthController(UserRegistrationService userRegistrationService, UserLoginService userLoginService, UserRepository userRepository) {
        this.userRegistrationService = userRegistrationService;
        this.userLoginService = userLoginService;

    }
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInRequest signInRequest) {
        return userLoginService.signInUser(signInRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpRequest signUpRequest) {
        return userRegistrationService.registerUser(signUpRequest, false);
    }

//    @PostMapping("/admin/signup")
//    public ResponseEntity<String> adminSignup(@RequestBody SignUpRequest signUpRequest) {
//        return userRegistrationService.registerUser(signUpRequest, true);
//    }
    @GetMapping("/allusers/{offset}/{pagesize}")
   public Page<User> findAllUsers(@PathVariable int offset, @PathVariable int pagesize){
        return userRegistrationService.returnPagedUsers(offset,pagesize);
    }
    @GetMapping("/user/{id}")
        public ResponseEntity<RegisteredUser> users(@PathVariable Long id){
        return userRegistrationService.findById(id);
    }
}
