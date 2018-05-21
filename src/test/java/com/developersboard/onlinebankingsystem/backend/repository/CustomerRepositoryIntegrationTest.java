package com.developersboard.onlinebankingsystem.backend.repository;

import com.developersboard.onlinebankingsystem.OnlineBankingSystemApplicationTests;
import com.developersboard.onlinebankingsystem.backend.domain.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class CustomerRepositoryIntegrationTest extends OnlineBankingSystemApplicationTests {

    @Autowired
    private CheckingTransactionRepository checkingTransactionRepository;

    @Autowired
    private SavingsTransactionRepository savingsTransactionRepository;

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    @Autowired
    private CheckingAccountRepository checkingAccountRepository;

    @Autowired
    private  DebitCardRepository debitCardRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private  CheckingAccount checkingAccount;
    private  SavingsAccount savingsAccount;
    private  DebitCard debitCard;

   private Customer aNewCustomer;

    @Test
    void setUp() {
        CheckingTransaction checkingTransaction1 = new CheckingTransaction();
        CheckingTransaction checkingTransaction2 = new CheckingTransaction();
        checkingTransaction1.setDescription("checkingTransaction description1");
        checkingTransaction2.setDescription("checkingTransaction description2");

        //save checkingTransaction to DB
        checkingTransactionRepository.save(checkingTransaction1);
        checkingTransactionRepository.save(checkingTransaction2);

        checkingAccount = new CheckingAccount();
        checkingAccount.setAccountNumber("123456");
        checkingAccount.setBalance(BigDecimal.ZERO);

        // save checkingAccount to DB
        CheckingAccount savedCheckingAccount = checkingAccountRepository.save(checkingAccount);
        savedCheckingAccount.getCheckingTransactions().add(checkingTransaction1);
        savedCheckingAccount.getCheckingTransactions().add(checkingTransaction2);

        checkingAccountRepository.save(savedCheckingAccount);


        //----------------------------------------------------------------------

        SavingsTransaction savingsTransaction1 = new SavingsTransaction();
        SavingsTransaction savingsTransaction2 = new SavingsTransaction();
        savingsTransaction1.setDescription("savingsTransation description1");
        savingsTransaction2.setDescription("savingsTransation description2");

        // save savingsTransaction to DB
        savingsTransactionRepository.save(savingsTransaction1);
        savingsTransactionRepository.save(savingsTransaction2);

        // create SavingsAccount
        savingsAccount = new SavingsAccount();
        savingsAccount.setAccountNumber("12367");

        // save savingsAccount to DB
        SavingsAccount savedSavingsAccount =  savingsAccountRepository.save(savingsAccount);
        savedSavingsAccount.getSavingsTransactions().add(savingsTransaction1);
        savedSavingsAccount.getSavingsTransactions().add(savingsTransaction2);

        savingsAccountRepository.save(savedSavingsAccount);

        //----------------------------------------------------------------------

        debitCard = new DebitCard();

    }



    @Test
    @DisplayName("Customer creation test")
    void testCustomerCreation(){

        //Create and save Customer
        aNewCustomer = new Customer();
        aNewCustomer.setCheckingAccount(checkingAccount);
        aNewCustomer.setSavingsAccount(savingsAccount);
        aNewCustomer.getDebitCard().add(debitCard);

        // save Customer to DB
        customerRepository.save(aNewCustomer);

        List<Customer> foundCustomer = (List<Customer>)customerRepository.findAll();

        assertThat(foundCustomer, is(notNullValue()));
    }


    @Test
    void testFindByEmail() {

        aNewCustomer = new Customer();
        aNewCustomer.setEmail("georgeanguah@yahoo.com");
        Customer savedCustomer = customerRepository.save(aNewCustomer);
        assertNotNull(savedCustomer);
        assertNotNull(savedCustomer.getId());

        // retrieve customer from db
        Customer foundContact = customerRepository.findByEmail("georgeanguah@yahoo.com");

        // Assertion
        assertThat(foundContact.getEmail(), is(equalTo("georgeanguah@yahoo.com")));
    }


    @Test
    public void testJunit5(){

    }
}