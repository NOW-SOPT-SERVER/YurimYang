package com.example.week1.domain.bank.exception;

public class OutOfMoneyException extends RuntimeException {

    public OutOfMoneyException() {
        super("출금할 금액이 계좌 잔액을 초과합니다.");
    }

}
