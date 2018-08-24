package com.developersboard.onlinebankingsystem.backend.service.imp;

import com.developersboard.onlinebankingsystem.backend.domain.*;
import com.developersboard.onlinebankingsystem.backend.repository.CheckingAccountRepository;
import com.developersboard.onlinebankingsystem.backend.repository.CustomerRepository;
import com.developersboard.onlinebankingsystem.backend.repository.SavingsAccountRepository;
import com.developersboard.onlinebankingsystem.backend.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static Integer nextDebitCardNumber = 1000;
    private static Integer nextCheckingAccountNumber = 12345;
    private static Integer nextSavingsAccountNumber = 54321;

    private final CheckingAccountRepository checkingAccountRepository;
    private final SavingsAccountRepository savingsAccountRepository;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(
            CheckingAccountRepository checkingAccountRepository, SavingsAccountRepository savingsAccountRepository,
            CustomerRepository customerRepository) {
        this.checkingAccountRepository = checkingAccountRepository;
        this.savingsAccountRepository = savingsAccountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {

        //TODO: 1. The customer needs checking account
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setAccountNumber(getNextCheckingAccountNumber().toString());

        // save checkingAccount to database and get back assigned object with id
        checkingAccount = checkingAccountRepository.save(checkingAccount);
        customer.setCheckingAccount(checkingAccount);

        //TODO: 2. The customer needs savings account
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountNumber(getNextSavingsAccountNumber().toString());

        //TODO: 3. The customer needs debit card
        DebitCard debitCard = new DebitCard();
        debitCard.setCardNumber(getNextDebitCardNumber());

        customer.setDebitCards(new HashSet<>(Collections.singletonList(debitCard)));



        return customerRepository.save(customer);
    }

    /**
     * @throws IllegalAccessException if id is null
     */
    @Override
    public Optional<Customer> getCustomerById(Long id) {
//        validateInput(id);
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomerById(Long id) {
         customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> saveCustomer(Customer customer) {

        Customer save = customerRepository.save(customer);
        return Optional.of(save);
    }

    // TODO : Refactor Code

    /**
     *
     * @return the a list of all the Customers
     */
    @Override
    public List<? extends User> getAllUser() {

        Iterable<Customer> customerIterable = customerRepository.findAll();
        Iterator<Customer> customerItr = customerIterable.iterator();
        List<Customer> customerList = new ArrayList<>();

        while(customerItr.hasNext())
            customerList.add(customerItr.next());

        return customerList;
    }

    /**
     *
     * @param user
     *        The modified user to be saved into DB
     *
     * @return the saved user(ie customer)
     */
    @Override
    public User updateUserInfo(User user) {
        return customerRepository.save((Customer) user);
    }



    private Integer getNextDebitCardNumber() {
        return ++nextDebitCardNumber;
    }

    private Integer getNextCheckingAccountNumber() {
        return ++nextCheckingAccountNumber;
    }

    private Integer getNextSavingsAccountNumber() {
        return ++nextSavingsAccountNumber;
    }
}
