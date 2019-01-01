package com.developersboard.onlinebankingsystem.backend.service.imp;

import com.developersboard.onlinebankingsystem.backend.service.CheckingAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements CheckingAccountService {

    @Override
    public boolean depositAccount(double amount) {
        return false;
    }

    @Override
    public boolean withdrawAccount(double amount) {
        return false;
    }
}
