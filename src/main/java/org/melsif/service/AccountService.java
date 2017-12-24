package org.melsif.service;

import org.apache.log4j.Logger;
import org.melsif.model.Security.Account;
import org.melsif.model.Security.Role;
import org.melsif.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {

    private final Logger LOGGER = Logger.getLogger(AccountService.class);


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(String.format("Username [%s] not found", username));
        }
        return account;
    }

    public Account registerUser(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.grantAuthority(Role.ROLE_USER);
        return accountRepository.save( account );
    }

}
