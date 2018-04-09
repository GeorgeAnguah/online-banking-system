package com.developersboard.onlinebankingsystem.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SavingsTransaction extends Transaction implements Serializable {

    private static final long serialVersionUID = 4821257814322810666L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "savings_account_id", unique = true)
    private SavingsAccount savingsAccount;
}
