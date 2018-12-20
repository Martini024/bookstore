package com.bookstore.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {

    private Integer ordId;

    private Customer customer;

    private Integer ordTotalnum;

    private Integer ordTotalmoney;

    private Date ordCreatedata;

    private String ordState;

    private Address address;

    private List<OrderDetail> orderDetailList;

}