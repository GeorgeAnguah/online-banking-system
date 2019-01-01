package com.developersboard.onlinebankingsystem.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CheckingTransaction extends Transaction implements Serializable {

    private static final long serialVersionUID = 8312300137727984275L;

    private String transactionMsg;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "checking_account_id", unique = true)
    private CheckingAccount checkingAccount;
}
