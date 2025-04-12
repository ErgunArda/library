package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.domain.model.Book;
import com.example.dto.DtoBookRequest;

@Mapper(componentModel = "spring")
public interface BookMapperRequest {
	Book toEntityBook(DtoBookRequest dtoBookRequest);
	DtoBookRequest toDtoBookRequest(Book book);
}
