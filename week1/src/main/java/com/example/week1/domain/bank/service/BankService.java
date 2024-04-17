package com.example.week1.domain.bank.service;

import lombok.RequiredArgsConstructor;
import com.example.week1.domain.bank.dto.request.DepositRequestDTO;
import com.example.week1.domain.bank.dto.request.WithdrawalRequestDTO;
import com.example.week1.domain.bank.dto.response.InquiryAccountResponse;
import com.example.week1.domain.bank.entity.Bank;
import com.example.week1.domain.bank.exception.AccountNotFoundException;
import com.example.week1.domain.bank.exception.OutOfMoneyException;
import com.example.week1.domain.bank.repository.BankRepository;
import com.example.week1.domain.member.entity.Member;
import com.example.week1.domain.member.exception.MemberNotFoundException;
import com.example.week1.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void postAccount(Long memberId, String account) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(MemberNotFoundException::new);
        if (!checkDuplicate(account)) {
            throw new AccountNotFoundException();
        }
        bankRepository.save(Bank.builder().member(member).account(account).money(0).build());
    }

    public boolean checkDuplicate(String account) {
        if (bankRepository.existsByAccount(account)) {
            return false;
        }
        return true;
    }

    @Transactional(readOnly = true)
    public InquiryAccountResponse getAccount(String account) {
        Bank bank = bankRepository.findByAccount(account)
            .orElseThrow(AccountNotFoundException::new);

        return InquiryAccountResponse.builder()
            .account(bank.getAccount())
            .money(bank.getMoney())
            .build();

    }

    @Transactional
    public void deposit(DepositRequestDTO depositRequestDTO) {
        Bank bank = bankRepository.findByAccount(depositRequestDTO.getAccount())
            .orElseThrow(AccountNotFoundException::new);
        bank.depositMoney(depositRequestDTO.getMoney());
    }

    @Transactional
    public void withdrawal(WithdrawalRequestDTO withdrawalRequestDTO) {
        Bank bank = bankRepository.findByAccount(withdrawalRequestDTO.getAccount())
            .orElseThrow(AccountNotFoundException::new);
        int withdrawalMoney = withdrawalRequestDTO.getMoney();
        if (!isOutOfMoney(bank, withdrawalMoney)) {
            throw new OutOfMoneyException();
        }
        bank.withDrawMoney(withdrawalRequestDTO.getMoney());
    }

    public boolean isOutOfMoney(Bank bank, int money) {
        if (bank.getMoney() - money < 0) {
            return false;
        }
        return true;
    }

}
