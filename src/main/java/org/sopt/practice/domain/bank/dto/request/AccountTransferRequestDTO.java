package org.sopt.practice.domain.bank.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountTransferRequestDTO {

    private String account;
    private Integer money;

    @Builder
    public AccountTransferRequestDTO(String account, Integer money) {
        this.account = account;
        this.money = money;
    }
}
