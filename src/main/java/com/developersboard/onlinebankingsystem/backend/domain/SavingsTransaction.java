package com.developersboard.onlinebankingsystem.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SavingsTransaction extends Transaction {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "savings_account_id", unique = true)
    private SavingsAccount savingsAccount;
}
