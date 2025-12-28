package za.co.lzinc.heriplay.factory.authentication;

import org.junit.jupiter.api.Test;
import za.co.lzinc.heriplay.domain.Name;
import za.co.lzinc.heriplay.domain.authentication.Role;
import za.co.lzinc.heriplay.domain.authentication.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void login() {
        String userName = "username";
        String password = "password";

        User user = UserFactory.login(userName,password);
        assertNotNull(user);
        System.out.println(user);
    }

    @Test
    void register() {
        Name name = new Name.Builder()
                .setFirstName("Luke")
                .setLastName("Vasile")
                .build();
        String userName = "username";
        String email = "email";
        String password = "password";
        Role role = Role.USER;

        User registeredUser = UserFactory.register(name, userName, email, password, role);
        assertNotNull(registeredUser);
    }
}