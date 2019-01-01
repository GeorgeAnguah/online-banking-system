package com.developersboard.onlinebankingsystem.backend.service;

import com.developersboard.onlinebankingsystem.backend.domain.CheckingTransaction;
import com.developersboard.onlinebankingsystem.backend.domain.Customer;

import java.util.List;

public interface CheckingTransactionService {

    List<CheckingTransaction> listAll(Customer customer);



}
