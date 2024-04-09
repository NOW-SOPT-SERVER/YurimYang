package org.sopt.practice.domain.bank.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.practice.domain.bank.dto.request.DepositRequestDTO;
import org.sopt.practice.domain.bank.dto.request.WithdrawalRequestDTO;
import org.sopt.practice.domain.bank.dto.response.InquiryAccountResponse;
import org.sopt.practice.domain.bank.service.BankService;
import org.sopt.practice.global.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/bank")
public class BankRestController {

    private final BankService bankService;

    /**
     * [POST] 계좌 등록 API
     *
     * @param memberId
     * @param account
     */
    @PostMapping("/{member_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDTO<Void> postAccount(@PathVariable("member_id") Long memberId,
        @Valid @RequestParam("account") String account) {
        bankService.postAccount(memberId, account);
        return ResponseDTO.res("계좌 등록에 성공했습니다.");
    }

    /**
     * [GET] 계좌 조회 API
     *
     * @param account
     * @return InquiryAccountResponse
     */
    @GetMapping("/inquiry")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO<InquiryAccountResponse> getAccount(
        @Valid @RequestParam("account") String account) {
        return ResponseDTO.res(bankService.getAccount(account), "계좌 조회에 성공했습니다.");
    }


    /**
     * [POST] 입급 API
     *
     * @param depositRequestDTO
     */
    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO<Void> deposit(@Valid @RequestBody DepositRequestDTO depositRequestDTO) {
        bankService.deposit(depositRequestDTO);
        return ResponseDTO.res("입금에 성공했습니다.");
    }

    /**
     * [POST] 출금 API
     *
     * @param withdrawalRequestDTO
     */
    @PostMapping("/withdrawal")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO<Void> withdrawal(
        @Valid @RequestBody WithdrawalRequestDTO withdrawalRequestDTO) {
        bankService.withdrawal(withdrawalRequestDTO);
        return ResponseDTO.res("출금에 성공했습니다.");
    }
}


