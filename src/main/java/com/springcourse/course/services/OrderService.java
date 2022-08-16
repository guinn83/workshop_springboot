package com.springcourse.course.services;

import com.springcourse.course.entities.Order;
import com.springcourse.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
