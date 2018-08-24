package com.developersboard.onlinebankingsystem.backend.service;

import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import com.developersboard.onlinebankingsystem.backend.domain.User;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Optional<Customer> getCustomerById(Long id) throws IllegalAccessException;

    void deleteCustomerById(Long id);

    Optional<Customer> saveCustomer(Customer customer);

    List<? extends User> getAllUser();

    User updateUserInfo(User user);

}
