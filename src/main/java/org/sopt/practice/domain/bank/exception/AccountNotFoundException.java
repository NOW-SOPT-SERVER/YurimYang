package org.sopt.practice.domain.bank.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException() {
        super("계좌를 찾을 수 없습니다.");
    }

}
