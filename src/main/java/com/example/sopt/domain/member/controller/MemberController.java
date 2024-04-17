package com.example.sopt.domain.member.controller;

import com.example.sopt.domain.member.dto.MemberCreateDto;
import com.example.sopt.domain.member.dto.MemberFindDto;
import com.example.sopt.domain.member.dto.MemberGetAllDto;
import com.example.sopt.domain.member.service.MemberService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity createMember(
        @RequestBody MemberCreateDto memberCreate
    ) {
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreate))).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(
        @PathVariable Long memberId
    ) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @GetMapping()
    public ResponseEntity<MemberGetAllDto> findAllMember(){
        return ResponseEntity.ok(memberService.findAllMember());
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMemberById(
        @PathVariable Long memberId
    ) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }


}
