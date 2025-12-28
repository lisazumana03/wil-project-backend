package za.co.lzinc.heriplay.dto.authentication;

import za.co.lzinc.heriplay.domain.Name;
import za.co.lzinc.heriplay.domain.authentication.Role;

public record RegisterRequestDTO(
        int userId,
        Name name, // Optional name
        String email,
        String userName, // Optional userName
        String password,
        Role role
) {
    public RegisterRequestDTO {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }
}
