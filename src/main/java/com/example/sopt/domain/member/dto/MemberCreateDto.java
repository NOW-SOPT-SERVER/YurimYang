package com.example.sopt.domain.member.dto;

import com.example.sopt.domain.member.entity.Part;

public record MemberCreateDto(
    String name,
    Part part,
    int age
) {
}
