package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.service.ILoanAppService;
import com.example.dto.DtoLoanRequest;
import com.example.dto.DtoLoanResponse;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/rest/api/loan")
public class LoanController {
	
	@Autowired
	ILoanAppService loanAppService;
	
	@PostMapping(path = "/save")
	public DtoLoanResponse saveLoan(DtoLoanRequest request) {
		
		return loanAppService.saveLoan(request);
	}
	
	@GetMapping(path = "/list")
	public List<DtoLoanResponse> findAllLoans(){
		return loanAppService.findAllLoans();
	}
	
	@GetMapping(path = "/list-book/{id}")
	public List<DtoLoanResponse> findLoansByBook(@PathVariable(name = "id",required = true) Long id){
		return loanAppService.findLoansByBook(id);
	}
	
	
	@GetMapping(path = "/list-user/{id}")
	public List<DtoLoanResponse> findLoansByUser(@PathVariable(name = "id",required = true) Long id){
		return loanAppService.findLoansByUser(id);
	}
	
	@PostMapping(path = "/return/{loanId}")
	public String postMethodName(@RequestBody String entity) {
		//TODO: process POST request
		
		return entity;
	}
	
}
