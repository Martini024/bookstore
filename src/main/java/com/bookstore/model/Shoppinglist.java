package com.bookstore.model;

import lombok.Data;

@Data
public class Shoppinglist {

    private Integer custId;

    private Book book;

    private Integer shopQuantity;

    private Integer shopTotalprice;

}