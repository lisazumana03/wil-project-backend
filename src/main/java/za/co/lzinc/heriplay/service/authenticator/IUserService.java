package za.co.lzinc.heriplay.service.authenticator;


import za.co.lzinc.heriplay.domain.authentication.User;
import za.co.lzinc.heriplay.dto.authentication.LoginRequestDTO;
import za.co.lzinc.heriplay.dto.authentication.RegisterRequestDTO;
import za.co.lzinc.heriplay.dto.authentication.UpdateUserDTO;
import za.co.lzinc.heriplay.dto.authentication.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDTO> getUsers();

    @Deprecated
    UserDTO register(RegisterRequestDTO registerRequestDTO);
    @Deprecated
    Optional<UserDTO> login(LoginRequestDTO loginRequestDTO);
    Optional<UserDTO> getProfile(int userId);
    UserDTO updateProfile(int userId, UpdateUserDTO userUpdateDTO);
    void deleteUser(int userId);
    User getUserByUsername(String userName);
}
