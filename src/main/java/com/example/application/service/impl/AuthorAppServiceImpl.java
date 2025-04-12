package com.example.application.service.impl;

import java.util.ArrayList;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.application.service.IAuthorAppService;
import com.example.domain.model.Author;
import com.example.domain.repository.IAuthorRepository;
import com.example.dto.DtoAuthor;
import com.example.mapper.AuthorMapper;

@Service
public class AuthorAppServiceImpl implements IAuthorAppService{
	
	@Autowired
	AuthorMapper authorMapper;
	@Autowired
	IAuthorRepository authorRepository;
	
	
	
	@Override
	public DtoAuthor save(DtoAuthor dtoAuthor) {
		Author author = authorMapper.toEntity(dtoAuthor);
		dtoAuthor = authorMapper.toDto(authorRepository.save(author)); // gerek yok ama mantık olarak boyle olması gerektigi icin yaptım
		// Cunku dto'lar IU ve Get olarak ayrılacaklar ben tek dto kullandım kısaca gerek yok ama gör diye.
		return dtoAuthor;
	}

	@Override
	public List<DtoAuthor> findAllAuthor() {
		List<DtoAuthor> dtoAuthorList = new ArrayList<>();
		List<Author> authorList = authorRepository.findAllAuthor();
		for(Author author: authorList) {
			System.out.println("Author = " + author.getFullName() + " Author id:" + author.getId());
			DtoAuthor dtoAuthor = authorMapper.toDto(author);
			System.out.println("Dto Author = " + dtoAuthor.getFullName());
			dtoAuthorList.add(dtoAuthor);
		}
		
		
		return dtoAuthorList;
	}

	@Override
	public DtoAuthor findAuthorById(Long id) {
		Author author = authorRepository.findAuthorById(id);
		DtoAuthor dtoAuthor = authorMapper.toDto(author);
		return dtoAuthor;
	}

	@Override
	public DtoAuthor findAuthorByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
