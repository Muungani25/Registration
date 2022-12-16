package com.example.registration.service.registration;

import com.example.registration.domain.User;
import com.example.registration.dto.JwtResponse;
import com.example.registration.dto.RegisteredUser;
import com.example.registration.dto.SignUpRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserRegistrationService {
    ResponseEntity<String> registerUser(SignUpRequest signUpRequest, Boolean isAdmin);
    List<User> returnUser();
    Page<User> returnPagedUsers(int offset, int pagesize);
    ResponseEntity<RegisteredUser> findById(Long id);
}
