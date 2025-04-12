package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.domain.model.Loan;
import com.example.dto.DtoLoanRequest;

@Mapper(componentModel = "spring")
public interface LoanMapperRequest {
	public Loan toEntity(DtoLoanRequest dtoLoanRequest);
	public DtoLoanRequest toDtoLoanRequest(Loan loan);
}
