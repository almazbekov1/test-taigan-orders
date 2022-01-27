//package com.example.testtaiganorders.test;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "tariff_statuses")
//public class TariffStatus {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(cascade = CascadeType.ALL
//            , fetch = FetchType.LAZY
//
//    )
//    private Tariff tariff;
//    @ManyToOne(cascade = CascadeType.ALL
//            , fetch = FetchType.LAZY
//
//    )
//    private Status status;
//
//
//    private Date date;
//
//}
