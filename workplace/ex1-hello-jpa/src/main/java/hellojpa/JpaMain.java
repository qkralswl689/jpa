package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
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

           /* Member member1 = new Member(150L,"A");
            Member member2 = new Member(160L,"B");

            em.persist(member1);
            em.persist(member2);
            System.out.println("================");

*/

    /*        Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            *//*member.setId("ID_A");*//*
            member2.setUsername("B");
            *//*member.setRoleType(RoleType.ADMIN);*//*

            Member member3 = new Member();
            member3.setUsername("A");

            System.out.println("==========");

            em.persist(member1); // 1,51
            em.persist(member2); // MEM
            em.persist(member3); // MEM

            System.out.println("member.id = " + member1.getId());
            System.out.println("member.id = " + member2.getId());
            System.out.println("member.id = " + member3.getId());

            System.out.println("==========");

            tx.commit();*/

            // 저장 => 객체의 참조와 DB의 외래키 매핑 하여 연관관계 매핑

       /*     Team team = new Team();
            team.setName("TeamA");
           *//* team.getMembers().add(member);*//*
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");

            //연관관계 편의 메소드
           *//* member.changeTeam(team); *//*
            em.persist(member);

            //연관관계 편의 메소드
            team.addMember(member);


            //1차 캐시가 아닌 DB 에서 가져옴
            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members){
                System.out.println("m = " + m.getUsername());
            }*/
/*

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();
            for (Member m : members){
                System.out.println("m = " + m.getUsername());
            }
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

            // 수정 -> 100번팀이 있다고 가정하에
            Team newTeam = em.find(Team.class, 100L);
            findMember.setTeam(newTeam);
*/

   /*         // 1 : N 단방향
            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(member);

            em.persist(team);
            */

    /*        // 영화 저장
            Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbb");
            movie.setName("바람과 함께");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMove = em.find(Movie.class, movie.getId());*/

/*            // 영화 저장
            Member member = new Member();
            member.setUsername("user1");
            member.setCreateBy("kim");
            member.setCreateDate(LocalDateTime.now());

            em.persist(member);

            em.flush();
            em.clear();*/

      /*      Member member = em.find(Member.class, 1L);
            PrintMember(member);

            printMemberAndTeam(member);*/

    /*        Child ch1 = new Child();
            Child ch2 = new Child();

            Parent parent = new Parent();
            parent.addChild(ch1);
            parent.addChild(ch2);

            em.persist(parent);

            em.flush();
            em.clear();
            Parent findParent = em.find(Parent.class, parent.getId());
            parent.getChildList().remove(0);*/

          /*  List<Member> result = em.createQuery("select m FROM Member m where m.username like '%kim%'",Member.class).getResultList();*/

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            Root<Member> m = query.from(Member.class);

           /* CriteriaQuery<Member> cq =
            query.select(m) .where(cb.equal((m.get("uwername"), "kim"));
            List<Member> resultList = em.createQuery(cq).getResultList();*/
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();

        /*Team team = member.getTeam();*/
    }

    private static void PrintMember(Member member) {
        System.out.println("member = " + member.getUsername());

    }

}
