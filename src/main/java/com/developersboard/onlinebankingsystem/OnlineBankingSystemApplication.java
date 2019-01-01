package com.developersboard.onlinebankingsystem;

import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import com.developersboard.onlinebankingsystem.backend.domain.DebitCard;
import com.developersboard.onlinebankingsystem.backend.repository.CustomerRepository;
import com.developersboard.onlinebankingsystem.backend.repository.DebitCardRepository;
import com.developersboard.onlinebankingsystem.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class OnlineBankingSystemApplication {


	public static void main(String[] args) {
		SpringApplication.run(OnlineBankingSystemApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(CustomerService customerService) {
//
//
//
//        return args -> {
//
//            Customer customer1 = new Customer();
//            customer1.setUsername("George");
//
//            Customer customer2 = new Customer();
//            customer2.setUsername("Eric");
//
//            Customer customer3 = new Customer();
//            customer3.setUsername("Daniel");
//
//            customerService.createCustomer(customer1);
//            customerService.createCustomer(customer2);
//            customerService.createCustomer(customer3);
//
//            // update user info( e.g change user name)
//            //customer1.setLastName("Anguah");
//        };
//	}

}
