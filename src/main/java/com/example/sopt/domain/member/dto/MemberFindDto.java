package com.example.sopt.domain.member.dto;

import com.example.sopt.domain.member.entity.Member;
import com.example.sopt.domain.member.entity.Part;

public record MemberFindDto(
    String name,
    Part part,
    int age
) {

    public static MemberFindDto of(
        Member member
    ) {
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }
}
