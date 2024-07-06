package com.example.crud.controller;

import com.example.crud.model.Order;
import com.example.crud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

public class OrderController {


  @RestController
  @RequestMapping("order")
  public class OrderControl {
    @Autowired
    private OrderService orderService;


    @PostMapping
    public Order addOrder(@RequestBody Order order) throws IOException {
      Order createdOrder = orderService.addOrder(order);

      return createdOrder;
    }

    @GetMapping
    public List<Order> findAllOrders() throws IOException {

      List<Order> orders = orderService.findAllOrders();
      return orders;

    }
  }

}
