package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // finall 붙은거만 생성자 생성
//@AllArgsConstructor // 모든 생성자 생성
public class MemberService {


    private final MemberRepository memberRepository;

//    @Autowired
//    public MemberService(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    // 회원가입 -> 독립적인 트랜잭션으로 사용하기 위해 @Transactional 붙혀줌 : 기본적으로 readOnly = false
    @Transactional
    public Long join (Member member){
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
       List<Member> findMembers =  memberRepository.findByName(member.getName());

        // EXCEPTION
       if(!findMembers.isEmpty()){
           throw  new IllegalStateException("이미 존재하는 회원입니다.");
       }
    }

    // 회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
