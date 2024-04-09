package org.sopt.practice.domain.bank.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BankPostResponse {

    private String name;
    private String account;

    @Builder
    public BankPostResponse(String name, String account) {
        this.name = name;
        this.account = account;
    }
}
