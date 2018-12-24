package com.bookstore.service;

import com.bookstore.model.Customer;

import java.util.List;

public interface CustomerService {

    public abstract Integer login(Customer.Account account);

    public abstract Integer register(Customer customer);

    public abstract Integer updateCustomer(Customer customer);

    public abstract Customer getCustomerById(Integer id);

//    public abstract boolean resetPasswordByEmail(String email);

}
