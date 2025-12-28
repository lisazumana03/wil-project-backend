package za.co.lzinc.heriplay.dto.authentication;

import za.co.lzinc.heriplay.domain.Name;
import za.co.lzinc.heriplay.domain.authentication.Role;

public record UserDTO(
        int userId,
        Name name,
        String userName,
        String email,
        String password,
        Role role
) {
}
