package com.example.crud.service;


import com.example.crud.model.Order;

import java.io.IOException;
import java.util.List;

public interface OrderService {

  Order addOrder(Order order) throws IOException;
  List<Order> findAllOrders() throws IOException;
}

