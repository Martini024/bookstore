package com.bookstore.model;

import lombok.Data;

@Data
public class ShopingList {

    private Customer customer;

    private Book book;

    private Integer shopQuantity;

    private Integer shopTotalprice;

}