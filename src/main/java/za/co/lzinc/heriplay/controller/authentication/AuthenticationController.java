package za.co.lzinc.heriplay.controller.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.lzinc.heriplay.config.AuthenticationService;
import za.co.lzinc.heriplay.dto.authentication.AuthenticationRequest;
import za.co.lzinc.heriplay.dto.authentication.LoginRequestDTO;
import za.co.lzinc.heriplay.dto.authentication.RegisterRequestDTO;

@RestController
@RequestMapping("/api/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationRequest> register(
            @RequestBody RegisterRequestDTO request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationRequest> authenticate(
            @RequestBody LoginRequestDTO authRequest) {
        return ResponseEntity.ok(userService.authenticate(authRequest));
    }
}
