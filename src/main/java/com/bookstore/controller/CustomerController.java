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


//
//    @PostMapping(value = "")
//    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
////        userService.createUser(user);
////        return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
//    }

    @PostMapping(value = "/login")
    public boolean login(@Valid  @RequestBody Customer.Account account) {
        log.info("login");
        if (customerService.login(account) != -1) {
            log.info("index");
            return true;
        }
        else {
            log.info("login");
            return false;
        }
    }

    @PostMapping(value = "/register")
    public Integer register(@Valid @RequestBody Customer customer) {
        return customerService.register(customer);
    }

    @PutMapping(value = "/{id}")
    public boolean updateCustomer(@PathVariable("id") Integer id, @Valid @RequestBody Customer customer) {
        customer.setCustId(id);
        return customerService.updateCustomer(customer);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

}
