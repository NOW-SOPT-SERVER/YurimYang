package org.sopt.practice.domain.bank.exception;

public class AccountDuplicateException extends RuntimeException {

    public AccountDuplicateException() {
        super("이미 등록된 계좌입니다.");
    }
}
