package com.example.application.service;

import java.util.List;

import com.example.dto.DtoLoanRequest;
import com.example.dto.DtoLoanResponse;

public interface ILoanAppService {
	public DtoLoanResponse saveLoan(DtoLoanRequest dtoLoanRequest);
	public List<DtoLoanResponse> findAllLoans();
	public List<DtoLoanResponse> findLoansByBook(Long id);
	public List<DtoLoanResponse> findLoansByUser(Long id);
}
