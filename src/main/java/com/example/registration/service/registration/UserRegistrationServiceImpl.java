package com.example.registration.service.registration;

import com.example.registration.domain.ERole;
import com.example.registration.domain.Role;
import com.example.registration.domain.User;
import com.example.registration.dto.JwtResponse;
import com.example.registration.dto.RegisteredUser;
import com.example.registration.dto.SignUpRequest;
import com.example.registration.repository.RoleRepository;
import com.example.registration.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    public UserRegistrationServiceImpl(UserRepository userRepository,
                                       RoleRepository roleRepository,
                                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

    }
    @Override
    public ResponseEntity<String> registerUser(SignUpRequest signUpRequest, Boolean isAdmin) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("username is already taken");
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email is already taken");
        }
        String hashedPassword = passwordEncoder.encode(signUpRequest.getPassword());
        Set<Role> roles = new HashSet<>();
        Optional<Role> userRole = isAdmin ? roleRepository.findByName(ERole.ROLE_ADMIN) : roleRepository.findByName(ERole.ROLE_USER);

        if (!userRole.isPresent()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("role not found");
        }
        roles.add(userRole.get());
        User user = new User();
        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(hashedPassword);
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully  please sign in");
    }

    @Override
    public List<User> returnUser() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> returnPagedUsers(int offset,int pagesize) {
        return userRepository.findAll(PageRequest.of(offset,pagesize));
    }
    public ResponseEntity<RegisteredUser> findById(Long id){
        Optional<User> user=userRepository.findById(id);
        if(!user.isPresent()){
            throw new IllegalStateException("the user id does not exist");
        }
        RegisteredUser response= RegisteredUser.builder()
                .id(user.get().getId())
                .firstname(user.get().getFirstname())
                .lastname(user.get().getLastname())
                .username(user.get().getUsername())
                .build();
        return ResponseEntity.ok(response);
    }
}
