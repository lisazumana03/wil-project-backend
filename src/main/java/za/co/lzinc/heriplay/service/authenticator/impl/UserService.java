package za.co.lzinc.heriplay.service.authenticator.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import za.co.lzinc.heriplay.domain.authentication.User;
import za.co.lzinc.heriplay.dto.authentication.LoginRequestDTO;
import za.co.lzinc.heriplay.dto.authentication.RegisterRequestDTO;
import za.co.lzinc.heriplay.dto.authentication.UpdateUserDTO;
import za.co.lzinc.heriplay.dto.authentication.UserDTO;
import za.co.lzinc.heriplay.mapper.authentication.UserMapper;
import za.co.lzinc.heriplay.repository.authentication.AuthenticationRepository;
import za.co.lzinc.heriplay.service.authenticator.IUserService;

@Service
public class UserService implements IUserService {

    private final AuthenticationRepository authenticationRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(AuthenticationRepository authenticationRepository, PasswordEncoder passwordEncoder) {
        this.authenticationRepository = authenticationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> getUsers() {
        return authenticationRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Deprecated //Using AuthenticationService.register()
    public UserDTO register(RegisterRequestDTO registerRequestDTO) {
        User user = new User.Builder()
                .setUserId(registerRequestDTO.userId())
                .setName(registerRequestDTO.name())
                .setEmail(registerRequestDTO.email())
                .setUserName(registerRequestDTO.userName())
                .setPassword(passwordEncoder.encode(registerRequestDTO.password()))
                .setRole(registerRequestDTO.role())
                .build();

        User savedUser = authenticationRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    @Override
    @Deprecated //Using AuthenticationService.authenticate()
    public Optional<UserDTO> login(LoginRequestDTO loginRequestDTO) {
        User user = authenticationRepository.findByUserName(loginRequestDTO.email())
                .orElse(null);

        if (user != null && passwordEncoder.matches(loginRequestDTO.password(), user.getPassword())) {
            return Optional.of(UserMapper.toDTO(user));
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> getProfile(int userId) {
        return authenticationRepository.findById(userId).map(UserMapper::toDTO);
    }

    @Override
    public UserDTO updateProfile(int userId, UpdateUserDTO userUpdateDTO) {
        User current = authenticationRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User does not exist"));

        User updated = new User.Builder()
                .setUserId(current.getUserId())
                .setName(userUpdateDTO.name())
                .setUserName(current.getUserName())
                .setEmail(userUpdateDTO.email())
                .setPassword(current.getPassword())
                .setRole(userUpdateDTO.role())
                .setName(userUpdateDTO.name())
                .setUserName(current.getUserName())
                .setEmail(userUpdateDTO.email())
                .setPassword(current.getPassword())
                .setRole(userUpdateDTO.role())
                .build();

        User saved = authenticationRepository.save(updated);
        return UserMapper.toDTO(saved);
    }

    @Override
    public void deleteUser(int userId) {
        authenticationRepository.deleteById(userId);
    }

    @Override
    public User getUserByUsername(String userName) {
        return authenticationRepository.findByUserName(userName).orElse(null);
    }
}