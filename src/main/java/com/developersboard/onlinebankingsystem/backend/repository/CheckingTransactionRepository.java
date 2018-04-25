package com.developersboard.onlinebankingsystem.backend.repository;

import com.developersboard.onlinebankingsystem.backend.domain.CheckingTransaction;
import org.springframework.data.repository.CrudRepository;

public interface CheckingTransactionRepository extends CrudRepository<CheckingTransaction, Long> {
}
