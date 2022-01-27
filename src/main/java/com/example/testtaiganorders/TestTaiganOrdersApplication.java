package com.example.testtaiganorders;


import com.example.testtaiganorders.test.EnumStatus;
import com.example.testtaiganorders.test.Status;
import com.example.testtaiganorders.test.Tariff;
import com.example.testtaiganorders.test.repo.OrderRepo;
import com.example.testtaiganorders.test.repo.StatusRepo;
import com.example.testtaiganorders.test.repo.TariffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class TestTaiganOrdersApplication {

    @Autowired
    private TariffRepo tariffRepo;
    @Autowired
    private StatusRepo statusRepo;

//    @PostConstruct
    public void get(){
        Status status1 = new Status("не назначен", EnumStatus.NOT_ASSIGNED);
        Status status2 = new Status("назначен",EnumStatus.ASSIGNED);
        Status status3 = new Status("в пути",EnumStatus.DRIVER_ON_THE_WAY);
        Status status4 = new Status("у курьера",EnumStatus.PICK_UP);
        Status status5 = new Status("на складе",EnumStatus.IN_STOCK);
        Status status6 = new Status("в дороге",EnumStatus.ON_THE_WAY);
        Status status7 = new Status("на складе в регионе",EnumStatus.IN_STOCK_REGION);
        Status status8 = new Status("у курьера в регионе",EnumStatus.PICK_UP_REGION);
        Status status9 = new Status("доставлено",EnumStatus.DELIVERED);
        Status status10 = new Status("отменен",EnumStatus.CANCELED);

        statusRepo.saveAll(List.of(status1,status2,status3,status4,status5,status6,status7,status8,status9,status10));

        Tariff tariff1 = new Tariff("REGION",166d,gets());
        tariffRepo.save(tariff1);
        Tariff tariff2 = new Tariff("CITY_MASTER",200d,List.of(get(5l)
                ,get(6l),get(7l),get(8l)
                ,get(9l),get(10l)));
        tariffRepo.save(tariff2);
        Tariff tariff3 = new Tariff("CITY",800d,List.of(get(1l),get(2l),get(3l),get(4l),get(9l),get(10l)));
        tariffRepo.save(tariff3);







    }
    private Status get(Long id){
        return statusRepo.getById(id);
    }
    private List<Status> gets(){
        return statusRepo.findAll();
    }
    public static void main(String[] args) {
        SpringApplication.run(TestTaiganOrdersApplication.class, args);
    }
}
