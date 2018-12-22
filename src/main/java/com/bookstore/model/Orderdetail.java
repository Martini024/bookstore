package com.bookstore.model;

import lombok.Data;

@Data
public class Orderdetail {

    private Integer orddId;

    private Order order;

    private Integer orddNum;

    private Integer orddPrice;

    private Book book;

}