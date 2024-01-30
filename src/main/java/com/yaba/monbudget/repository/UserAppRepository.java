package com.yaba.monbudget.repository;

import com.yaba.monbudget.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAppRepository extends JpaRepository<UserApp, UUID> {

    boolean existsByPhoneNumber(String phoneNumber);
}
