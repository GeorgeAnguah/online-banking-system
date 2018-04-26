package com.developersboard.onlinebankingsystem.backend.repository;

import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Customer findByEmail(String email);
}
