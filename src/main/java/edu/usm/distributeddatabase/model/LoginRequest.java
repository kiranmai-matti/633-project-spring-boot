package edu.usm.distributeddatabase.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/**
 * Login Request Model for the Request Payload
 */
public class LoginRequest {
    private String email;
    private String password;
}
