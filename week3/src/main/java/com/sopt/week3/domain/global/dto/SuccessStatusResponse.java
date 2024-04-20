package com.sopt.week3.domain.global.dto;

import com.sopt.week3.domain.global.exception.message.SuccessMessage;

public record SuccessStatusResponse(
    int status,
    String message
) {

    public static SuccessStatusResponse of(SuccessMessage successMessage) {
        return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage());
    }
}
