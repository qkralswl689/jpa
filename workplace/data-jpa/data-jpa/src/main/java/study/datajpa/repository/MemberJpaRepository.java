package study.datajpa.repository;

import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
@Repository
public class MemberJpaRepository {
    
    @PersistenceContext
    private EntityManager em; public Member save(Member member) {
        em.persist(member);
        return member;
    }
    
    public void delete(Member member) {
        em.remove(member);
    }
    
    // 전체 조회
    public List<Member> findAll() {
        // JPQL 사용
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    // Optional로 조회
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    // 단건 조회
    public long count() {
        return em.createQuery("select count(m) from Member m", Long.class)
                .getSingleResult();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

    // 이름과 나이를 기준으로 회원 조회
    public List<Member> findByUsernameAndAgeGreaterThan(String username, int age) {
        return em.createQuery("select m from Member m where m.username = :username and m.age > :age")
                .setParameter("username", username)
                .setParameter("age", age)
                .getResultList();
    }
}