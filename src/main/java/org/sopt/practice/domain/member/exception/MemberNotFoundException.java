package org.sopt.practice.domain.member.exception;

public class MemberNotFoundException extends RuntimeException{

    public MemberNotFoundException(){
        super("멤버를 찾을 수 없습니다.");
    }

}
