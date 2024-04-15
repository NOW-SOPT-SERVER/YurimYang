package org.sopt.practice.domain.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.sopt.practice.domain.member.entity.Member;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Comment("은행 식별자")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    @Comment("멤버 식별자")
    private Member member;

    @Column(length = 100)
    @Comment("계좌")
    private String account;

    @Column
    @Comment("잔액")
    private int money;

    @Builder
    public Bank(Long id, Member member, String account, int money) {
        this.id = id;
        this.member = member;
        this.account = account;
        this.money = money;
    }

    public void depositMoney(int money) {
        this.money += money;
    }

    public void withDrawMoney(int money) {
        this.money -= money;
    }
}
