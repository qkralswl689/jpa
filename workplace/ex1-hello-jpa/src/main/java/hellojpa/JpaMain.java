package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 데이터 저장
            /*Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            em.persist(member);*/

            // 데이터 찾기
    /*        Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());*/

            // 데이터 수정
         /*   Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");*/

   /*         // 전체 회원 조회
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();
*/
            /*// 페이징
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(8)
                    .getResultList();

            for(Member member:result){
                System.out.println("member.name = " + member.getName());
            }*/

            // 비영속
       /*     Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");
*/
            //영속
            // 1차 캐시 조회
/*            System.out.println("BEFORE");
            em.persist(member);
            System.out.println("ATFTER");

            Member findMember = em.find(Member.class, 101L);
             System.out.println("findMember = " + findMember.getId());
            System.out.println("findMember = " + findMember.getName());*/

            // DB 조회
/*            Member findMember1 = em.find(Member.class,101L);
            Member findMember2 = em.find(Member.class,101L);

            System.out.println("result = " + (findMember1 == findMember2));*/

            Member member1 = new Member(150L,"A");
            Member member2 = new Member(160L,"B");

            em.persist(member1);
            em.persist(member2);
            System.out.println("================");


            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

}
