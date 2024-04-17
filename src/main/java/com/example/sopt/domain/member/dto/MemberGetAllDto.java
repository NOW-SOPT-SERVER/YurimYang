package com.example.sopt.domain.member.dto;

import com.example.sopt.domain.member.entity.Member;
import java.util.List;
import lombok.Builder;

public record MemberGetAllDto(
    List<MemberFindDto> members) {

    public static MemberGetAllDto of(
        List<MemberFindDto> members

    ) {
        return new MemberGetAllDto(members);
    }
}
