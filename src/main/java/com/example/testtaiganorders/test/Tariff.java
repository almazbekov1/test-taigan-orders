package com.example.testtaiganorders.test;


import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @OneToMany(cascade = CascadeType.ALL
            , fetch = FetchType.LAZY
            ,mappedBy = "tariff1"
    )
    private List<Order> orders;


//    @ManyToOne(cascade = CascadeType.ALL
//            ,fetch = FetchType.LAZY
//    )
//    private List<Order> orders;

    @ManyToMany(fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "tariff_statuses",
            joinColumns = {@JoinColumn(name = "tariff_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "status_id", referencedColumnName = "id")})
    private List<Status> status;

    public Tariff() {
    }

    public Tariff(String name, Double price, List<Status> status) {
        this.name = name;
        this.price = price;
        this.status = status;
    }
}
