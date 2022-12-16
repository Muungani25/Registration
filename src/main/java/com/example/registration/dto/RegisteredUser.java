package com.example.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisteredUser {
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
}
