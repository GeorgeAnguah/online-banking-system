package com.developersboard.onlinebankingsystem.backend.repository;

import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import com.developersboard.onlinebankingsystem.backend.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByEmail(String email);

    Customer findCustomerByUsername(String username);

    Customer findCustomerByEmail(String email);
}

