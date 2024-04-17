package com.example.week1.domain.bank.repository;

import java.util.Optional;
import com.example.week1.domain.bank.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Optional<Bank> findByAccount(String account);

    boolean existsByAccount(String account);
}
