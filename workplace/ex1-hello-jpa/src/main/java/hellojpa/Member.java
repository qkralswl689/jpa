package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// JPA 가 관리하는 객체라는 표시
@Entity
/*@SequenceGenerator(name = "member_seq_generator",sequenceName = "member_seq")*/
/*@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)*/
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 50)

public class Member {

    @Id
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "member_seq_generator")*/
       /* @GeneratedValue(strategy = GenerationType.TABLE,
                generator = "MEMBER_SEQ_GENERATOR")*/
   /* @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR")*/
    @GeneratedValue
    @Column(name = "MEMBER_ID")
        private Long id;

    @Column(name = "USERNAME")
    private String username;

    @OneToOne
    @JoinColumn(name = "LOKER_ID")
    private Locker locker;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT")
    private List<Product> products = new ArrayList<>();
 /*   @Column(name = "TEAM_ID")
    private Long teamId;*/

/*    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;*/

/*    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }*/

   /* public void changeTeam(Team team) {
        this.team = team;

        // 연관관계 편의메소드
        team.getMembers().add(this);
    }*/

    /* private Integer age;

            @Enumerated(EnumType.STRING)
            private RoleType roleType;

            @Temporal(TemporalType.TIMESTAMP)
            private Date createdDate;

            @Temporal(TemporalType.TIMESTAMP)
            private Date lastModifiedDate;

            private LocalDate testLocalDate;
            private LocalDateTime testLocalDateTime;

            @Lob
            private String description;
        */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   /* public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }*/
}
