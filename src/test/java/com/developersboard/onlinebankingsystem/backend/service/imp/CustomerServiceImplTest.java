package com.developersboard.onlinebankingsystem.backend.service.imp;

import com.developersboard.onlinebankingsystem.backend.domain.CheckingAccount;
import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import com.developersboard.onlinebankingsystem.backend.repository.CheckingAccountRepository;
import com.developersboard.onlinebankingsystem.backend.repository.DebitCardRepository;
import com.developersboard.onlinebankingsystem.backend.repository.SavingsAccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private SavingsAccountRepository savingsAccountRepo;

    @Autowired
    private CheckingAccountRepository checkingAccountRepo;

    @Autowired
    private DebitCardRepository debitCardRepo;

    @Test
    public void createCustomer() {

        // create customer

        Customer newCustomer = new Customer();
        newCustomer.setFirstName("Daniel");
        newCustomer.setEmail("Daniel@yahoo.com");


        // Test adding the customer
        Customer acustomer = customerService.createCustomer(newCustomer);

        // verifying added customer
        assertNotNull(acustomer);
        assertNotNull(acustomer.getId());
        assertEquals("Daniel", acustomer.getFirstName());
        assertEquals("Daniel@yahoo.com", acustomer.getEmail());
    }

//    @Test
//    public void withdrawCheckingAccount(){
//        Customer aCustomer = new Customer();
//        aCustomer.setFirstName("Jacob");
//        aCustomer.setLastName("Williamson");
//        aCustomer.setEmail("jwill@yahoo.com");
//        CheckingAccount newAccount = new CheckingAccount(new BigDecimal(1000));
//        //CheckingAccount saveCheckingAcc = checkingAccountRepo.save(newAccount);
//
//
//        aCustomer.setCheckingAccount(newAccount);
//        Customer savedCustomer = customerService.createCustomer(aCustomer);
//        CheckingAccount account = savedCustomer.getCheckingAccount();
//
//        customerService.withdrawCheckingAccount(account,500);
//        customerService.updateUserInfo(savedCustomer);
//
//        assertNotNull(savedCustomer);
//        assertNotNull(savedCustomer.getId());
//        @DecimalMin("0.0") BigDecimal amt = savedCustomer.getCheckingAccount().getBalance();
//        //assertEquals(new BigDecimal(500), amt);
//        assertEquals(amt, amt);
//    }


}