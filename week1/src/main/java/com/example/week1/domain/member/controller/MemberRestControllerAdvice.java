package com.example.week1.domain.member.controller;

import com.example.week1.domain.member.exception.MemberNotFoundException;
import com.example.week1.global.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemberRestControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO<Void> memberNotFoundException(MemberNotFoundException e){
        return ResponseDTO.res(e.getMessage());
    }
}
