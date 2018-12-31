package com.bookstore.service;

import com.bookstore.model.Address;

import java.util.List;

public interface AddressService {

    public abstract Integer createAddress(Address address);

    public abstract Integer deleteAddress(Integer addrId);

    public abstract Integer updateAddress(Address address);

    public abstract List<Address> getAddressByCustomer(Integer custId);

}
