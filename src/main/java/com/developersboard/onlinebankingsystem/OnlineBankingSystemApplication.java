package com.developersboard.onlinebankingsystem;

import com.developersboard.onlinebankingsystem.backend.domain.DebitCard;
import com.developersboard.onlinebankingsystem.backend.repository.DebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineBankingSystemApplication {

    @Autowired
    private DebitCardRepository cardRepository;

	public static void main(String[] args) {
		SpringApplication.run(OnlineBankingSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
        DebitCard debitCard = new DebitCard();
        debitCard.setCardNumber(3456);
        debitCard.setCvv("125");
        debitCard.setExpiredMonth("09");
        debitCard.setExpiredYear("2019");
		return args -> {
		  // place your code here
            // Save demo dat to database

            cardRepository.save(debitCard);
        };
	}

}
