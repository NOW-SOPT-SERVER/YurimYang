package com.sopt.week3.domain.service;

import com.sopt.week3.domain.entity.Member;
import com.sopt.week3.domain.repository.MemberRepository;
import com.sopt.week3.domain.global.exception.NotFoundException;
import com.sopt.week3.domain.global.exception.message.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findById(Long memberId){
        return memberRepository.findById(memberId).orElseThrow(
            () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        );

    }


}
