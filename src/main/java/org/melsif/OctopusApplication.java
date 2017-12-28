package org.melsif;

import org.melsif.model.Security.Account;
import org.melsif.model.Security.Role;
import org.melsif.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class OctopusApplication {

    public static void main(String[] args) {
        SpringApplication.run(OctopusApplication.class, args);
    }

    public void run(String... args) {

    }
    @Bean
    CommandLineRunner init(
            AccountService accountService
    ) {
        return (evt) ->
            Arrays.asList("user", "admin").forEach(
                    username -> {
                        Account account = new Account();
                        account.setUsername(username);
                        account.setPassword("password");
                        account.setFirstName(username);
                        account.setLastName("LastName");
                        account.grantAuthority(Role.ROLE_USER);
                        if (username.equals("admin"))
                            account.grantAuthority(Role.ROLE_ADMIN);
                        accountService.registerUser(account);
                    }
            );
    }
}