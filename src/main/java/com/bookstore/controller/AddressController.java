package com.bookstore.controller;

import com.bookstore.model.Address;
import com.bookstore.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping(value = "")
    public ResponseEntity<Object> createAddress(@Valid @RequestBody Address address) {
        return new ResponseEntity<>(addressService.createAddress(address), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteAddress(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(addressService.deleteAddress(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Integer id, @RequestBody Address address) {
        address.setAddrId(id);
        return new ResponseEntity<>(addressService.updateAddress(address), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getAddressByCustomer(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(addressService.getAddressByCustomer(id), HttpStatus.OK);
    }

}
