package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.domain.model.Category;
import com.example.dto.DtoCategory;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	Category toEntity(DtoCategory dtoCategory);
	DtoCategory toDto(Category category);
}
