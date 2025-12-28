package za.co.lzinc.heriplay.factory.authentication;

import za.co.lzinc.heriplay.domain.Name;
import za.co.lzinc.heriplay.domain.authentication.Role;
import za.co.lzinc.heriplay.domain.authentication.User;

public class UserFactory {
    public static User login(String userName, String password) {
        return new User.Builder()
                .setUserName(userName)
                .setPassword(password)
                .build();
    }

    public static User register(Name name, String userName, String email, String password, Role role) {
        return new User.Builder()
                .setName(name)
                .setUserName(userName)
                .setEmail(email)
                .setPassword(password)
                .setRole(role)
                .build();
    }
}
