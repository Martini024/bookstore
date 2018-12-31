package com.bookstore.serviceImpl;

import com.bookstore.mapper.AddressMapper;
import com.bookstore.model.Address;
import com.bookstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public Integer createAddress(Address address) {
        return addressMapper.insert(address);
    }

    @Override
    public Integer deleteAddress(Integer addrId) {
        return addressMapper.deleteByPrimaryKey(addrId);
    }

    @Override
    public Integer updateAddress(Address address) {
        return addressMapper.updateByPrimaryKey(address);
    }

    @Override
    public List<Address> getAddressByCustomer(Integer custId) {
        return addressMapper.selectAddressByCustomer(custId);
    }
}
