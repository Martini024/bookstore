package com.bookstore.serviceImpl;

import com.bookstore.mapper.CustomerMapper;
import com.bookstore.model.Customer;
import com.bookstore.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Integer login(Customer.Account account) {
        Integer id = customerMapper.selectByCustName(account.getCustName());
        Customer customer1 = customerMapper.selectByPrimaryKey(id);
        if (customer1 != null && account.getCustPassword().equals(customer1.getCustPassword()))
            return customer1.getCustId();
        else
            return -1;
    }

    @Override
    public Integer register(Customer customer) {
        if (customerMapper.selectByCustName(customer.getCustName()) != null) {
            return -1;
        }
        else {
            return customerMapper.insert(customer);
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Integer id = customerMapper.selectByCustName(customer.getCustName());
        if (id != null && customer.getCustId() != id) {
            return false;
        }
        else {
            customerMapper.updateByPrimaryKey(customer);
            return true;
        }
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

//    @Override
//    public boolean resetPasswordByEmail(String email) {
//        return false;
//    }

}
