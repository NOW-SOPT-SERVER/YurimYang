package com.sopt.week3.domain.global.exception;

import com.sopt.week3.domain.global.exception.message.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
