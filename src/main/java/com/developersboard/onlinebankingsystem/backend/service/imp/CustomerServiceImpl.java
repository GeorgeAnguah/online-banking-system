package com.developersboard.onlinebankingsystem.backend.service.imp;

import com.developersboard.onlinebankingsystem.backend.domain.*;
import com.developersboard.onlinebankingsystem.backend.repository.CheckingAccountRepository;
import com.developersboard.onlinebankingsystem.backend.repository.CustomerRepository;
import com.developersboard.onlinebankingsystem.backend.repository.DebitCardRepository;
import com.developersboard.onlinebankingsystem.backend.repository.SavingsAccountRepository;
import com.developersboard.onlinebankingsystem.backend.service.CustomerService;
import com.developersboard.onlinebankingsystem.enums.UserType;
import org.springframework.stereotype.Service;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static Integer nextDebitCardNumber = 1000;
    private static Integer nextCheckingAccountNumber = 1223445;
    private static Integer nextSavingsAccountNumber = 5432145;

    private final CheckingAccountRepository checkingAccountRepository;
    private final SavingsAccountRepository savingsAccountRepository;
    private final CustomerRepository customerRepository;
    private final DebitCardRepository debitCardRepository;

    public CustomerServiceImpl(CheckingAccountRepository checkingAccountRepository, SavingsAccountRepository savingsAccountRepository, CustomerRepository customerRepository, DebitCardRepository debitCardRepository) {
        this.checkingAccountRepository = checkingAccountRepository;
        this.savingsAccountRepository = savingsAccountRepository;
        this.customerRepository = customerRepository;
        this.debitCardRepository = debitCardRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {


        CheckingAccount checkingAccount = new CheckingAccount(new BigDecimal(0.0));
        checkingAccount.setAccountNumber(getNextCheckingAccountNumber().toString());

        customer.setCheckingAccount(checkingAccount);

        // set customer reference in checkingAccount( reverse mapping)
       checkingAccount.setCustomer(customer);

        SavingsAccount savingsAccount = new SavingsAccount(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(getNextSavingsAccountNumber().toString());
        customer.setSavingsAccount(savingsAccount); // set customer savingAccount

        // set customer reference in savingsAccount( reverse mapping)
        savingsAccount.setCustomer(customer);

        DebitCard debitCard = new DebitCard();
        debitCard.setCardNumber(getNextDebitCardNumber());

        customer.setDebitCards(new HashSet<>(Collections.singletonList(debitCard)));

        // set customer reference in debitCard( reverse mapping)
        debitCard.setCustomer(customer);

        // set customer type : UserType
        customer.setType(UserType.CUSTOMER);

        return customerRepository.save(customer);
    }

    /**
     * @throws IllegalAccessException if id is null
     */
    @Override
    public Optional<Customer> getCustomerById(Long id) {
        //TODO: 1        validateInput(id);
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomerById(Long id) {
        //TODO: 1        validateInput(id);
        customerRepository.deleteById(id);
    }


/** */
    @Override
    public Iterable<? extends Customer> getAllUser() {
        return customerRepository.findAll();
    }

    // TODO : Refactor Code



    /**
     * @param user The modified user to be saved into DB
     * @return the saved user(ie customer)
     */
    @Override
    public Customer updateUserInfo(Customer user) {
        return customerRepository.save(user);
    }

    // Check if customer already exit in repository
    @Override
    public boolean customerExist(Customer customer) {
        if( checkEmailExist(customer.getEmail()) || checkUsernameExist(customer.getUsername())){
            return true;
        }

        return false;
    }

    /**
     *
     * @param email to be verify for duplicate
     * @return true if email already exit, otherwise false
     */
    @Override
    public boolean checkEmailExist(String email) {
        Customer customer = customerRepository.findCustomerByEmail(email);
        if (customer != null) return true;
        return false;
    }


    /**
     *
     * @param username to be verified for duplicate
     * @return true if email already exit, otherwise false
     */
    @Override
    public boolean checkUsernameExist(String username) {
        Customer customer = customerRepository.findCustomerByUsername(username);
        if (customer != null) return true;
        return false;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }

//    @Override
//    public boolean withdrawCheckingAccount(CheckingAccount account, double amount) {
//        BigDecimal bigDecimal = new BigDecimal(amount);
//        if(account.getBalance().subtract(bigDecimal).compareTo(bigDecimal) < 0   ) {
//            return false;
//
//        }else{
//            account.getBalance().subtract(bigDecimal); // substract amount from checking account
//        }
//        return true;
//    }


    private Integer getNextDebitCardNumber() {
        return nextDebitCardNumber++;
    }

    private Integer getNextCheckingAccountNumber() {
        return nextCheckingAccountNumber++;
    }

    private Integer getNextSavingsAccountNumber() {
        return nextSavingsAccountNumber++;
    }
}
