package com.example.crud.model;

import java.util.List;
import java.util.UUID;

import com.example.crud.model.Product;
//import com.example.crud.model.*
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
  private UUID id;
  private List<Product> products;
  private double totalAmount;

  @Override
  public String toString() {
    return "Order{" +
      "id=" + id +
      ", products=" + products +
      ", totalAmount=" + totalAmount +
      '}';
  }
}
