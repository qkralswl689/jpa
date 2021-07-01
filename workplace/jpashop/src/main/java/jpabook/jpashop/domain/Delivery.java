package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order")
    private Order order;


}
