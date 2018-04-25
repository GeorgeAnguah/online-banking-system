package com.developersboard.onlinebankingsystem.backend.repository;

import com.developersboard.onlinebankingsystem.backend.domain.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<Loan, Long> {
}
