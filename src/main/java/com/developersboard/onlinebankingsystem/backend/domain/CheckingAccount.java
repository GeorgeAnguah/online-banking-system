package com.developersboard.onlinebankingsystem.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"checkingAcc_id","checkingTransactions"})
@EqualsAndHashCode(of = {"accountNumber"})
public class CheckingAccount implements Serializable {

    private static final long serialVersionUID = -4452397797538826939L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long checkingAcc_id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @DecimalMin("0.0")
    private BigDecimal balance;

    @OneToMany(mappedBy = "checkingAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CheckingTransaction> checkingTransactions = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;

    public CheckingAccount(BigDecimal balance) {
        this.balance = balance;
    }
}
