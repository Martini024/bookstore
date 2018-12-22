package com.bookstore.model;

import lombok.Data;

@Data
public class Address {

    private Integer addrId;

    private Integer custId;

    private String addrName;

    private String addrPhone;

    private String addrAddress;

    private String addrZipcode;

}