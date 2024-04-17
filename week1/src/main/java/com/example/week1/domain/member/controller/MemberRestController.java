package com.example.week1.domain.member.controller;

import com.example.week1.domain.member.service.MemberService;
import com.example.week1.global.ResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDTO<Void> postMember(@Valid @RequestParam("name") String name) {
        memberService.postMember(name);
        System.err.println(name);
        return ResponseDTO.res("회원가입에 성공했습니다.");
    }
}
