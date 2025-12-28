package za.co.lzinc.heriplay.dto.authentication;

import za.co.lzinc.heriplay.domain.Name;
import za.co.lzinc.heriplay.domain.authentication.Role;

public record UpdateUserDTO(
        int userId,
        Name name,
        String email,
        String userName,
        Role role
) {
    public UpdateUserDTO {
        // Validation can be added here if needed
//        if (name == null || name.trim().isEmpty()) {
//            throw new IllegalArgumentException("First name cannot be null or empty");
//        }
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
    }
}
