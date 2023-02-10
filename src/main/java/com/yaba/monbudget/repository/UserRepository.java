package com.yaba.monbudget.repository;

import com.yaba.monbudget.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserApp, Long> {
    boolean existsByUsername(String username);
}
