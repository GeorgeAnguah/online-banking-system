package com.developersboard.onlinebankingsystem.backend.service;

import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import com.developersboard.onlinebankingsystem.backend.domain.DebitCard;

import java.util.Optional;

public interface DebitCardService {


    //Todo 1: Create a new DebitCard
    DebitCard createDebitCard (DebitCard debitCard);

    //Todo 2: Delete a DebitCard from Customer
    void deleteDebitCardById (Long id);

    //Todo 3: Find all Customer by DebitCard
    Optional<Customer> getCustomerByDebitCard (Long id);

    //Todo 4: save an already created DebitCard to DB
    DebitCard saveDebitCard (DebitCard debitCard);



}
