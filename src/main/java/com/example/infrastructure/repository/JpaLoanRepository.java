package com.example.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.model.Loan;

public interface JpaLoanRepository extends JpaRepository<Loan, Long>{
	List<Loan> findByBookId(Long id);
	List<Loan> findByUserId(Long id);
}
