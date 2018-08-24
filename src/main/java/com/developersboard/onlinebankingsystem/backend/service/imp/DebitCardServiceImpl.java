package com.developersboard.onlinebankingsystem.backend.service.imp;

import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import com.developersboard.onlinebankingsystem.backend.domain.DebitCard;
import com.developersboard.onlinebankingsystem.backend.service.DebitCardService;

import java.util.Optional;


public class DebitCardServiceImpl implements DebitCardService {

    private static Integer nextDebitCardNumber = 2345;


    @Override
    public DebitCard createDebitCard(DebitCard debitCard) {
        return null;
    }

    @Override
    public void deleteDebitCardById(Long id) {

    }

    @Override
    public Optional<Customer> getCustomerByDebitCard(Long id) {
        return Optional.empty();
    }

    @Override
    public DebitCard saveDebitCard(DebitCard debitCard) {
        return null;
    }
}
