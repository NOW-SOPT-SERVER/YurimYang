package com.example.week1.domain.bank.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DepositRequestDTO {

    private String account;
    private Integer money;

    @Builder
    public DepositRequestDTO(String account, Integer money) {
        this.account = account;
        this.money = money;
    }
}
