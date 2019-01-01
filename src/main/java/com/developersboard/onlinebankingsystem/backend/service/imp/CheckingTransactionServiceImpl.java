package com.developersboard.onlinebankingsystem.backend.service.imp;

import com.developersboard.onlinebankingsystem.backend.domain.CheckingTransaction;
import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import com.developersboard.onlinebankingsystem.backend.service.CheckingTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckingTransactionServiceImpl implements CheckingTransactionService {

    @Override
    public List<CheckingTransaction> listAll(Customer customer) {
        return null;
    }


}
