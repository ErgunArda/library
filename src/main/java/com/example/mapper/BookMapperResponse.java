package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.domain.model.Book;
import com.example.dto.DtoBookResponse;

@Mapper(componentModel = "spring")
public interface BookMapperResponse {
	Book toEntity(DtoBookResponse dtoBook);
	DtoBookResponse toDtoBookResponse(Book book);
}
