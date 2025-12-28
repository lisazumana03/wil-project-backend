package za.co.lzinc.heriplay.controller.authentication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import za.co.lzinc.heriplay.dto.authentication.UpdateUserDTO;
import za.co.lzinc.heriplay.dto.authentication.UserDTO;
import za.co.lzinc.heriplay.service.authenticator.impl.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://localhost:4516", "http://172.20.10.9:4516"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO> listUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public Optional<UserDTO> getProfile(@PathVariable Integer userId) {
        return userService.getProfile(userId);
    }

    @PutMapping("/{userId}")
    public UserDTO updateProfile(@PathVariable Integer userId, @RequestBody UpdateUserDTO updateDTO) {
        return userService.updateProfile(userId, updateDTO);
    }

    // Delete user - ADMIN only
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }

}