package com.bookstore.model;

import lombok.Data;

@Data
public class OrderDetail {

    private Integer orddId;

    private Integer ordId;

    private Integer orddNum;

    private Integer orddPrice;

    private Book book;

}