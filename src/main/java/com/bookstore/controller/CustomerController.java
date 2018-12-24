package com.bookstore.controller;

import com.bookstore.model.Customer;
import com.bookstore.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/login")
    public String login(@Valid @RequestBody Customer.Account account) {
        if (customerService.login(account) != -1) {
            log.info("index");
            return "success";
        }
        else {
            log.info("login");
            return "error";
        }
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.register(customer), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Integer id, @Valid @RequestBody Customer customer) {
        customer.setCustId(id);
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomerById(@PathVariable("id") Integer id) {
        return customerService.getCustomerById(id);
    }

}
