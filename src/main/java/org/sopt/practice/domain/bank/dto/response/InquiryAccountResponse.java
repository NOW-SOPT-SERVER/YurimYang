package org.sopt.practice.domain.bank.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InquiryAccountResponse {

    private String account;
    private int money;

    @Builder
    public InquiryAccountResponse(String account, int money) {
        this.account = account;
        this.money = money;
    }
}


