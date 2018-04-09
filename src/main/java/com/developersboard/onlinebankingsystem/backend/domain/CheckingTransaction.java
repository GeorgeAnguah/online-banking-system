package com.developersboard.onlinebankingsystem.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CheckingTransaction extends Transaction {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="checking_account_id", unique = true)
    private CheckingAccount checkingAccount;
}
