package com.developersboard.onlinebankingsystem.backend.repository;

import com.developersboard.onlinebankingsystem.backend.domain.CheckingAccount;
import org.springframework.data.repository.CrudRepository;

public interface CheckingAccountRepository extends CrudRepository<CheckingAccount, Long> {
}
