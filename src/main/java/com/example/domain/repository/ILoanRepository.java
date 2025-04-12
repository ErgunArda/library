package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.Loan;

public interface ILoanRepository {
	public Loan saveLoan(Loan loan);
	public List<Loan> findAllLoans();
	public Loan findLoanById(Long id);
	
	public List<Loan> findLoanByBook(Long id);
	public List<Loan> findLoanByUser(Long id);
	
	public Loan returnLoan(Long id);
}	
