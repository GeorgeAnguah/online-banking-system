package com.developersboard.onlinebankingsystem.backend.domain;

import com.developersboard.onlinebankingsystem.enums.LoanType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@MappedSuperclass
public class Loan {

    private Long id;
    private double interestRate;
    private BigDecimal amount;
    private String description;
    private LoanType loanType;
}
