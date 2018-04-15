package com.developersboard.onlinebankingsystem.backend.domain;

import com.developersboard.onlinebankingsystem.enums.LoanType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
// To be use by the User account.

@Data
@ToString
@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class Loan {

    @Id
    private int id;
    private String name;
    private double interestRate;
    private BigDecimal amount;
    private String description;

    public Loan(LoanType loanType) {
        this.id = loanType.getId();
        this.name = loanType.getName();
    }
}
