package com.developersboard.onlinebankingsystem.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data    // Generate setters and getters
@NoArgsConstructor
@ToString(exclude = {"savingsAcc_id", "savingsTransactions"})
@EqualsAndHashCode(of = {("accountNumber")})
public class SavingsAccount implements Serializable {

    private static final long serialVersionUID = -1904764044747218436L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long savingsAcc_id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @DecimalMin("0.0")
    private BigDecimal balance;

    @OneToMany(mappedBy = "savingsAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SavingsTransaction> savingsTransactions = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;


    public SavingsAccount(BigDecimal balance) {
        this.balance = balance;
    }
}
