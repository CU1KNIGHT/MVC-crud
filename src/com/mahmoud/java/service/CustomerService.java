package com.mahmoud.java.service;

import com.mahmoud.java.entity.Customer;

import java.util.List;

public interface CustomerService {
    List <Customer> getCustomers();

    void saveCustomer (Customer customer);

    Customer getCustomer (int id);

    void deleteCustomer (int id);

    List<Customer> searchCustomers (String searchName);
}
