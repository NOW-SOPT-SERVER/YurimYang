package org.sopt.practice.domain.member.controller;

import org.sopt.practice.domain.member.exception.MemberNotFoundException;
import org.sopt.practice.global.ResponseDTO;
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
