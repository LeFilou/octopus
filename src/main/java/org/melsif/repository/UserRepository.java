package org.melsif.repository;

import org.melsif.model.Security.Account;
import org.melsif.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByAccount_Username(String username);
}
