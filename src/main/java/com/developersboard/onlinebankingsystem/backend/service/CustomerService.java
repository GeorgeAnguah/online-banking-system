package com.developersboard.onlinebankingsystem.backend.service;

import com.developersboard.onlinebankingsystem.backend.domain.CheckingAccount;
import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import com.developersboard.onlinebankingsystem.backend.domain.User;

import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Optional<Customer> getCustomerById(Long id) throws IllegalAccessException;

    void deleteCustomerById(Long id);

//    Optional<Customer> saveCustomer(Customer customer);

    Iterable<? extends Customer> getAllUser();

    Customer updateUserInfo(Customer acustomer);

    /**
     *  verify whether customer already ezist
     * @param customer to be verified
     * @return true if customer exit, else return false
     */
    boolean customerExist (Customer customer);

    /**
     * Check if emall already exist
     * @param email to be verify for duplicate
     * @return true if email already exit, otherwise return false
     */
    boolean checkEmailExist(String email);

        // iterate through the customer repo
        // compare each email with emails in customer repo


    boolean checkUsernameExist(String username);

    Customer getCustomerByUsername(String username);

//    boolean withdrawCheckingAccount(CheckingAccount account, double amount);
}
