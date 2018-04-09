package com.developersboard.onlinebankingsystem.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"id"})
@EqualsAndHashCode(of={"accountNumber"})
public class CheckingAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String accountNumber;
    private double balance;

    @OneToMany(mappedBy = "checkingAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CheckingTransaction> checkingTransactions = new HashSet<>();
}
