package com.example.testtaiganorders.test.api;

import com.example.testtaiganorders.test.*;
import com.example.testtaiganorders.test.repo.OrderRepo;
import com.example.testtaiganorders.test.repo.TariffRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestApi {


    private final TariffRepo tariffRepo;
    private final OrderRepo orderRepo;

    public TestApi(OrderRepo orderRepo, TariffRepo tariffRepo) {
        this.orderRepo = orderRepo;
        this.tariffRepo = tariffRepo;
    }

    @GetMapping("/{tariffId}")
    public Order get(@RequestBody Order order, @PathVariable Long tariffId){
        Tariff tariff = tariffRepo.getById(tariffId);
        order.setOrderStatuses(gets(tariff,order));
        order.setTariff1(tariff);

        orderRepo.save(order);


        return null;
    }
    private List<OrderStatus> gets(Tariff tariff,Order order){
        List<OrderStatus> orderStatuses = new ArrayList<>();
        for (Status s:tariff.getStatus()) {
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setEnumStatus(s.getEnumStatus());
            orderStatus.setName(s.getName());
            orderStatus.setOrder(order);
            orderStatuses.add(orderStatus);
        }
        return orderStatuses;
    }
}
