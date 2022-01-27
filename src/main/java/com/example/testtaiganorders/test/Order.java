package com.example.testtaiganorders.test;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "order_tariffs",
//            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "tariff_id", referencedColumnName = "id")}
//    )
//    private List<Tariff> tariff1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_tariffs_id")
    private Tariff tariff1;

    @OneToMany(cascade = CascadeType.ALL
            , fetch = FetchType.LAZY
            ,mappedBy = "order"
    )
    private List<OrderStatus> orderStatuses;



}
