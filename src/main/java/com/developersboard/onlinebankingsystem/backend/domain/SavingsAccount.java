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
@Data    // Generate setters and getters
@NoArgsConstructor
@ToString(exclude = {"id", "savingsTransaction"})
@EqualsAndHashCode(of = {("accountNumber")})
public class SavingsAccount implements Serializable {

    private static final long serialVersionUID = -1904764044747218436L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    private double balance;

    @OneToMany(mappedBy = "savingsAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SavingsTransaction> savingsTransactions = new HashSet<>();

}
