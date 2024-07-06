package com.example.crud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public class Product {

    private Integer id;
    private  String name;
    private  String desciption;
    private Integer quantity;

    @Override
    public String toString() {
      return "product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", desciption='" + desciption + '\'' +
        ", quantity=" + quantity +
        '}';
    }
  }

