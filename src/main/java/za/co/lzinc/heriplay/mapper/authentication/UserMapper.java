package za.co.lzinc.heriplay.mapper.authentication;

import za.co.lzinc.heriplay.dto.authentication.RegisterRequestDTO;
import za.co.lzinc.heriplay.dto.authentication.UserDTO;
import za.co.lzinc.heriplay.domain.authentication.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
    }
    public static User toRegisterRequest(RegisterRequestDTO registerRequestDTO) {
        return new User.Builder()
                .setUserId(registerRequestDTO.userId())
                .setName(registerRequestDTO.name())
                .setEmail(registerRequestDTO.email())
                .setUserName(registerRequestDTO.userName())
                .setPassword(registerRequestDTO.password())
                .setRole(registerRequestDTO.role())
                .build();
    }
}
