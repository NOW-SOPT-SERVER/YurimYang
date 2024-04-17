package com.example.sopt.domain.member.service;

import com.example.sopt.domain.member.dto.MemberCreateDto;
import com.example.sopt.domain.member.dto.MemberFindDto;
import com.example.sopt.domain.member.dto.MemberGetAllDto;
import com.example.sopt.domain.member.entity.Member;
import com.example.sopt.domain.member.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public String createMember(
        MemberCreateDto memberCreateDto
    ) {
        Member member = Member.create(memberCreateDto.name(), memberCreateDto.part(), memberCreateDto.age());
        memberRepository.save(member);
        return member.getId().toString();
    }

    public MemberFindDto findMemberById(
        Long memberId
    ) {
        return MemberFindDto.of(memberRepository.findById(memberId).orElseThrow(
            () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        ));
    }

    @Transactional
    public void deleteMemberById(
        Long memberId
    ) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다."));
        memberRepository.delete(member);
    }

    public MemberGetAllDto findAllMember(){
        List<MemberFindDto> members = memberRepository.findAll()
            .stream()
            .map(member -> MemberFindDto.of(member))
            .collect(Collectors.toList());

        return MemberGetAllDto.of(members);
    }
}
