package org.sopt.practice.domain.bank.controller;

import org.sopt.practice.domain.bank.exception.AccountDuplicateException;
import org.sopt.practice.domain.bank.exception.AccountNotFoundException;
import org.sopt.practice.domain.bank.exception.OutOfMoneyException;
import org.sopt.practice.global.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BankRestControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO<Void> accountNotFoundException(AccountNotFoundException e) {
        return ResponseDTO.res(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO<Void> accountDuplicateException(AccountDuplicateException e) {
        return ResponseDTO.res(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO<Void> outOfMoneyException(OutOfMoneyException e) {
        return ResponseDTO.res(e.getMessage());
    }
}


