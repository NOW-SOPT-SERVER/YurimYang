package org.sopt.practice.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.domain.member.entity.Member;
import org.sopt.practice.domain.member.repository.MemberRepository;
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
