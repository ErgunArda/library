package com.example.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.service.ILoanAppService;
import com.example.domain.model.Book;
import com.example.domain.model.Loan;
import com.example.domain.model.User;
import com.example.domain.repository.IBookRepository;
import com.example.domain.repository.ILoanRepository;
import com.example.domain.repository.IUserRepository;
import com.example.dto.DtoLoanRequest;
import com.example.dto.DtoLoanResponse;
import com.example.mapper.LoanMapperRequest;
import com.example.mapper.LoanMapperResponse;

@Service
public class LoanAppServiceImpl implements ILoanAppService{
	
	@Autowired
	private ILoanRepository loanRepository;
	
	@Autowired
	private LoanMapperRequest loanMapperRequest;
	
	@Autowired
	private LoanMapperResponse loanMapperResponse;
	
	@Autowired
	IBookRepository bookRepository;
	
	@Autowired
	IUserRepository userRepository;
	
	@Override
	public DtoLoanResponse saveLoan(DtoLoanRequest dtoLoanRequest) {
		Loan loan = loanMapperRequest.toEntity(dtoLoanRequest);
		loan.setReturnDate(null);
		Book book = bookRepository.findBookById(dtoLoanRequest.getBookId());
		User user = userRepository.findUserById(dtoLoanRequest.getUserId());
		loan.setBook(book);
		loan.setUser(user);
		loanRepository.saveLoan(loan);
		
		book.setQuantity(book.getQuantity() -1);
		user.setActiveLoanCount(user.getActiveLoanCount() + 1);
		
		DtoLoanResponse loanResponse = loanMapperResponse.tDtoLoanResponse(loan);
		loanResponse.setBookTitle(loan.getBook().getTitle());
		loanResponse.setUsername(loan.getUser().getUsername());
		
		return loanResponse;
	}
	
	@Override
	public List<DtoLoanResponse> findAllLoans() {
		List<Loan> loanList = loanRepository.findAllLoans();
		List<DtoLoanResponse> dtoLoanResponseList = new ArrayList<>();
		
		for(Loan loan:loanList) {
			DtoLoanResponse dtoLoanResponse = loanMapperResponse.tDtoLoanResponse(loan);
			dtoLoanResponse.setBookTitle(loan.getBook().getTitle());
			dtoLoanResponse.setUsername(loan.getUser().getUsername());
			dtoLoanResponseList.add(dtoLoanResponse);
		}	
		return dtoLoanResponseList;
	}

	@Override
	public List<DtoLoanResponse> findLoansByBook(Long id) {
		List<Loan> loanList = loanRepository.findLoanByBook(id);
		List<DtoLoanResponse> dtoLoanResponseList = new ArrayList<>();
		
		for(Loan loan:loanList) {
			DtoLoanResponse dtoLoanResponse = loanMapperResponse.tDtoLoanResponse(loan);
			dtoLoanResponse.setBookTitle(loan.getBook().getTitle());
			dtoLoanResponse.setUsername(loan.getUser().getUsername());
			dtoLoanResponseList.add(dtoLoanResponse);
		}
		return dtoLoanResponseList;
	}

	@Override
	public List<DtoLoanResponse> findLoansByUser(Long id) {
		List<Loan> loanList = loanRepository.findLoanByUser(id);
		List<DtoLoanResponse> dtoLoanResponseList = new ArrayList<>();
		
		for(Loan loan:loanList) {
			DtoLoanResponse dtoLoanResponse = loanMapperResponse.tDtoLoanResponse(loan);
			dtoLoanResponse.setBookTitle(loan.getBook().getTitle());
			dtoLoanResponse.setUsername(loan.getUser().getUsername());
			dtoLoanResponseList.add(dtoLoanResponse);
		}
		return dtoLoanResponseList;
	}

	

}
