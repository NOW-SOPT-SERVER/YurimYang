package com.sopt.week3.domain.global.exception;

import com.sopt.week3.domain.global.exception.message.ErrorMessage;

public class BusinessException extends RuntimeException {

    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
