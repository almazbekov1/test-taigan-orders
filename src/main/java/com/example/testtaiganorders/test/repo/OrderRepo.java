package com.example.testtaiganorders.test.repo;

import com.example.testtaiganorders.test.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
