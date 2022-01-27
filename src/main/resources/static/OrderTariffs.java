//package com.example.testtaiganorders.test;
//
//import lombok.Data;
//import org.springframework.data.annotation.CreatedDate;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "order_tariffs")
//public class OrderTariffs {
////
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
////
////    @OneToMany(cascade = CascadeType.ALL
////            , fetch = FetchType.LAZY
////            ,mappedBy = "orderTariffs"
////    )
////    private List<Order> orders;
////
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "tariff_id")
////    private Tariff tariffs;
////
////    @CreatedDate
////    private Date date = new Date();
////
////
//}
