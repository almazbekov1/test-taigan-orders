package com.example.testtaiganorders.test;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean isActive;

    @CreatedDate
    private Date date;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "tariff_id")
//    private Tariff tariff2;

    @Enumerated(EnumType.STRING)
    private EnumStatus enumStatus;

    public Status() {
    }

    public Status(String name, EnumStatus enumStatus) {
        this.name = name;
        this.enumStatus = enumStatus;
    }
}
