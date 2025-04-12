package com.example.mapper;

import org.mapstruct.Mapper;



import com.example.domain.model.Author;
import com.example.dto.DtoAuthor;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
	Author toEntity(DtoAuthor dto);
	DtoAuthor toDto(Author entity);
}	
