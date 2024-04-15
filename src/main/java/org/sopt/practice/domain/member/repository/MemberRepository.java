package org.sopt.practice.domain.member.repository;

import org.sopt.practice.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
