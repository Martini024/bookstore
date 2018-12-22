package com.bookstore.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Customer {

    private Integer custId;

    @NotNull
    private String custName;

    @NotNull
    private String custPassword;

    @NotNull
    private String custRealname;

    @NotNull
    @Email
    private String custEmail;

    @NotNull
    private Date custCreatedate;

    private List<Address> addressList;

    private List<Order> orderList;

    private List<Shoppinglist> shoppinglist;

    public Customer(Integer custId, @NotNull String custName, @NotNull String custPassword, @NotNull String custRealname, @NotNull @Email String custEmail, @NotNull Date custCreatedate, List<Address> addressList, List<Order> orderList, List<Shoppinglist> shoppinglist) {
        this.custId = custId;
        this.custName = custName;
        this.custPassword = custPassword;
        this.custRealname = custRealname;
        this.custEmail = custEmail;
        this.custCreatedate = custCreatedate;
        this.addressList = addressList;
        this.orderList = orderList;
        this.shoppinglist = shoppinglist;
    }

    @Data
    @NoArgsConstructor
    public static class Account {

        @NotNull
        private String custName;

        @NotNull
        private String custPassword;

    }
}