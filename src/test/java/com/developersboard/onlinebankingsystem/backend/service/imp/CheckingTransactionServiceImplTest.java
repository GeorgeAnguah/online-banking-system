package com.developersboard.onlinebankingsystem.backend.service.imp;

import com.developersboard.onlinebankingsystem.backend.domain.*;
import com.developersboard.onlinebankingsystem.backend.service.CheckingAccountService;
import com.developersboard.onlinebankingsystem.backend.service.CheckingTransactionService;
import com.developersboard.onlinebankingsystem.backend.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CheckingTransactionServiceImplTest {

    @Autowired
    private CheckingTransactionServiceImpl transactionService;
    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CheckingAccountService accountService;

    @Test
    public void addTransactionToAccountEvent(){
        Customer aCustomer = new Customer();
        CheckingAccount checkingAccount = new CheckingAccount(new BigDecimal("100"));
        checkingAccount.setAccountNumber("1245895");

        SavingsAccount savingsAccount = new SavingsAccount(new BigDecimal("200"));
        savingsAccount.setAccountNumber("6547892");

        CheckingTransaction transaction = new CheckingTransaction("Test transaction event",checkingAccount );
        Set<CheckingTransaction> checkingTransactions = checkingAccount.getCheckingTransactions();
        checkingTransactions.add(transaction);
        checkingAccount.setCheckingTransactions(checkingTransactions);

        Customer saveCustomer = customerService.updateUserInfo(aCustomer);
        fail();
        assertNotNull(saveCustomer);
        assertEquals("Test transaction event", saveCustomer.getCheckingAccount().getCheckingTransactions().toString());

        //addTransaction()
    }




}