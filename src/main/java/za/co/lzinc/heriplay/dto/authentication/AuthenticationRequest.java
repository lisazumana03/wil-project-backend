package za.co.lzinc.heriplay.dto.authentication;

public record AuthenticationRequest(
        String token,
        UserDTO user,
        String tokenType
) {
    public AuthenticationRequest(String token, UserDTO user) {
        this(token, user, "Bearer");
    }
}
