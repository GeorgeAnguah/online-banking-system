package com.developersboard.onlinebankingsystem.backend.service;

import com.developersboard.onlinebankingsystem.backend.domain.CheckingAccount;

public interface CheckingAccountService {

    boolean depositAccount(double amount);

    boolean withdrawAccount(double amount);


}
