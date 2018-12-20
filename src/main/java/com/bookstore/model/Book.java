package com.bookstore.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Book {

    private Integer bookId;

    private String bookName;

    private BigDecimal bookPrice;

    private String bookAuthor;

    private Integer bookCount;

    private Integer bookDiscount;

    private Category category;

    private List<Customer> customerList;

}