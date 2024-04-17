package com.example.week1.domain.bank.controller;

import com.example.week1.domain.bank.exception.AccountDuplicateException;
import com.example.week1.domain.bank.exception.AccountNotFoundException;
import com.example.week1.domain.bank.exception.OutOfMoneyException;
import com.example.week1.global.ResponseDTO;
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


