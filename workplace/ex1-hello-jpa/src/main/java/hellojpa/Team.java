package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

   /* @OneToMany(mappedBy = "member")*/
/*    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<>();*/

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false,updatable = false)
    private Team team;

    /*public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }*/

/*    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public void addMember(Member member) {
        member.setTeam(this);*/
        /*        // 연관관계 편의메소드
        members.add(member);
    }*/

}
