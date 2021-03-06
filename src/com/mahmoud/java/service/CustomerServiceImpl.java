package com.mahmoud.java.service;

import com.mahmoud.java.dao.CustomerDAO;
import com.mahmoud.java.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List <Customer> getCustomers () {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer (Customer customer) {
         customerDAO.saveCustomer(customer);
    }

    @Transactional
    @Override
    public Customer getCustomer (int id) {
        return customerDAO.getCustomer(id);
    }

    @Transactional
    @Override
    public void deleteCustomer (int id) {
        customerDAO.deleteCustomer(id);
    }

    @Override
    @Transactional
    public List <Customer> searchCustomers (String searchName) {

        return customerDAO.searchCustomers(searchName);
    }
}
