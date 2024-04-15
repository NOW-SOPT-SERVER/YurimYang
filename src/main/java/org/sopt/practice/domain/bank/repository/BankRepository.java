package org.sopt.practice.domain.bank.repository;

import java.util.Optional;
import org.sopt.practice.domain.bank.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Optional<Bank> findByAccount(String account);

    boolean existsByAccount(String account);
}
