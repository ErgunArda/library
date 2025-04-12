package com.example.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.model.Loan;
import com.example.domain.repository.ILoanRepository;

@Repository
public class LoanReposityoryImpl implements ILoanRepository{
	
	@Autowired
	JpaLoanRepository jpaLoanRepository;

	@Override
	public Loan saveLoan(Loan loan) {
		return jpaLoanRepository.save(loan);
	}

	@Override
	public List<Loan> findAllLoans() {
		return jpaLoanRepository.findAll();
	}

	

	@Override
	public List<Loan> findLoanByBook(Long id) {
		return jpaLoanRepository.findByBookId(id);
	}

	@Override
	public List<Loan> findLoanByUser(Long id) {
		return jpaLoanRepository.findByUserId(id);
	}
	
	
	
	@Override
	public Loan findLoanById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan returnLoan(Long id) {
		jpaLoanRepository.findById(id);
		return null;
	}
}
