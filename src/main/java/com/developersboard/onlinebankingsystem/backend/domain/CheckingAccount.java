package com.developersboard.onlinebankingsystem.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"id"})
@EqualsAndHashCode(of = {"accountNumber"})
public class CheckingAccount implements Serializable {

    private static final long serialVersionUID = -4452397797538826939L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accountNumber;

    private double balance;

    @OneToMany(mappedBy = "checkingAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CheckingTransaction> checkingTransactions = new HashSet<>();
}
