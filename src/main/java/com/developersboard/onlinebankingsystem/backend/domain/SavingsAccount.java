package com.developersboard.onlinebankingsystem.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data    // Generate setters and getters
@NoArgsConstructor
@ToString(exclude = "id")
@EqualsAndHashCode(of = {("accountNumber")})
public class SavingsAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accountNumber;
    private double balance;

}
