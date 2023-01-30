package com.example.registration.service.authentication;

import com.example.registration.dto.JwtResponse;
import com.example.registration.dto.SignInRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<JwtResponse> signInUser(SignInRequest signInRequest);
}
