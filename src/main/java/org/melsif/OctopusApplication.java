package org.melsif;

import org.apache.log4j.Logger;
import org.melsif.model.Security.Account;
import org.melsif.model.Security.Role;
import org.melsif.model.User;
import org.melsif.service.AccountService;
import org.melsif.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class OctopusApplication {

    private static final Logger LOGGER = Logger.getLogger(OctopusApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OctopusApplication.class, args);
    }

    public void run(String... args) {

    }
    @Bean
    CommandLineRunner init(
            UserService userService,
            PasswordEncoder passwordEncoder
    ) {
        return (evt) ->
            Arrays.asList("user", "admin").forEach(
                    username -> {
                        Account account = new Account();
                        account.setUsername(username);
                        account.setPassword(passwordEncoder.encode("password"));
                        account.grantAuthority(Role.ROLE_USER);
                        if (username.equals("admin")) {
                            account.grantAuthority(Role.ROLE_ADMIN);
                        }
                        User user = User.builder()
                                .account(account)
                                .email("fliousalim@gmail.com")
                                .firstName("salim")
                                .lastName("fliou")
                                .matricule("AA12345" + Math.random())
                                .build();
                        LOGGER.info(user);
                        userService.registerUser(user);
                    }
            );
    }
}