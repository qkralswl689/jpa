package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test // 회원가입
    //@Rollback(value = false) // spring에서 Transactinal은 기본적으로 Rollback 시키기 때문에 Rollback 안하려는 설정
    public void join() throws Exception{
        //given
        Member member = new Member();
        member.setName("BAE");

        //when
        Long saveId = memberService.join(member);

        //then
        //em.flush(); DB에 데이터 저장하려면 설정
        assertEquals(member, memberRepository.findOne(saveId));
    }

    // 중복 회원
    @Test
    public void ex() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("BAE");

        Member member2 = new Member();
        member2.setName("BAE");

        //when
        memberService.join(member1);
        //memberService.join(member2); // 예외가 발생해야 한다


//        try {
//            memberService.join(member2); // 예외가 발생해야 한다
//
//        }catch (IllegalStateException e){
//            return;
//        }

       //then
        IllegalStateException thrown = assertThrows(IllegalStateException.class,()-> memberService.join(member2));
        assertEquals("이미 존재하는 회원입니다.",thrown.getMessage());
        //fail("예외가 발생해야 한다");
    }

}