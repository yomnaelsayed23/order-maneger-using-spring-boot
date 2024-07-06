package com.example.crud.service;
import com.example.crud.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class OrderServiceImpl implements OrderService {

  final static String DIRECTORY = "orders/";
  ObjectMapper mapper = new ObjectMapper();
  Path directory =(Paths.get(DIRECTORY));

  @Override
  public Order addOrder(Order order) throws IOException {
    UUID id = UUID.randomUUID();
    order.setId(id);
    try {
      boolean dirExist = Files.exists(Paths.get(directory.toUri()));
      if (!dirExist){
        Files.createDirectories(directory);
      }
      String fileName = DIRECTORY +order.getId() + ".json";
      Path filepath = Paths.get(fileName);
      Files.createFile(filepath);
      mapper.writeValue(filepath.toFile(),order);
    }catch (IOException x){
      System.err.format("createFile error: %s%n", x);
    }

    return order;
  }

  @Override
  public List<Order> findAllOrders() throws IOException {
    List<Order> orderList = new ArrayList<>();
    try {
      List<Path> filePaths = Files.walk(Paths.get(DIRECTORY)).filter(Files::isRegularFile).collect(Collectors.toList());
      for(Path path : filePaths){
        Order order = mapper.readValue(path.toFile(), Order.class);
        orderList.add(order);
      }
    }catch (IOException e){
      System.err.format("There is no files in the Directory : %s%n",e);
    }
    return orderList;
  }
}

