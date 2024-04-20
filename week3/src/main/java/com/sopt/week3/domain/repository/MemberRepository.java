package com.sopt.week3.domain.repository;

import com.sopt.week3.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
