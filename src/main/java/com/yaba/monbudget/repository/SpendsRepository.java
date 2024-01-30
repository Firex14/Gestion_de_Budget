package com.yaba.monbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendsRepository extends JpaRepository<Transactions, Long> {
}
