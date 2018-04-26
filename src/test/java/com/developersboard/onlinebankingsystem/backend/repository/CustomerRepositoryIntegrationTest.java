package com.developersboard.onlinebankingsystem.backend.repository;

import com.developersboard.onlinebankingsystem.OnlineBankingSystemApplication;
import com.developersboard.onlinebankingsystem.OnlineBankingSystemApplicationTests;
import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

//@RunWith(SpringRunner.class)
//@SpringBootTest (
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//        classes =  OnlineBankingSystemApplication.class
//)
//
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

public class CustomerRepositoryIntegrationTest extends OnlineBankingSystemApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFindByEmail() {

        // setup
        // Create and save customer record
        Customer aNewCustomer = new Customer();
        aNewCustomer.setEmail("georgeanguah@yahoo.com");
        customerRepository.save(aNewCustomer);

        // retrieve customer from db
        Customer foundContact = customerRepository.findByEmail("georgeanguah@yahoo.com");

        // Assertion
        assertThat(foundContact.getEmail(), is(equalTo("georgeanguah@yahoo.com")));
    }


}