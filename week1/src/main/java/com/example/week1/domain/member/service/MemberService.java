package com.example.week1.domain.member.service;

import com.example.week1.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import com.example.week1.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void postMember(String name){
        memberRepository.save(Member.builder().name(name).build());
    }
}
