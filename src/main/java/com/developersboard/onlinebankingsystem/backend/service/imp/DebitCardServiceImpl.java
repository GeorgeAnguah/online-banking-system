package com.developersboard.onlinebankingsystem.backend.service.imp;

import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import com.developersboard.onlinebankingsystem.backend.domain.DebitCard;
import com.developersboard.onlinebankingsystem.backend.repository.DebitCardRepository;
import com.developersboard.onlinebankingsystem.backend.service.DebitCardService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value="debitCardService")
public class DebitCardServiceImpl implements DebitCardService {

    private static Integer nextDebitCardNumber = 2345;

    private DebitCardRepository cardRepository;

    public DebitCardServiceImpl(DebitCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

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
