package com.bookstore.model;

import lombok.Data;

@Data
public class Address {

    private Integer addrId;

    private Customer customer;

    private String addrName;

    private String addrPhone;

    private String addrAddress;

    private String addrZipcode;

}