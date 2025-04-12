package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.domain.model.Loan;
import com.example.dto.DtoLoanResponse;

@Mapper(componentModel = "spring")
public interface LoanMapperResponse {
	Loan toEntity(DtoLoanResponse dtoLoanResponse);
	DtoLoanResponse tDtoLoanResponse(Loan loan);
}
