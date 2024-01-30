package com.yaba.monbudget.repository;

import com.yaba.monbudget.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAccountRepository extends JpaRepository<UserAccount, UUID> {
    UserAccount findByUsername(String username);
    boolean existsByUsernameIgnoreCase(String username);

}
