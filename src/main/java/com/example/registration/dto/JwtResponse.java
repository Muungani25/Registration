package com.example.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse {
   private String token;
    private String type = "Bearer";
    private Long id;
    private String firstname;
    private String lastname;
   private String email;
    private String username;
    private List<String> roles;
}
