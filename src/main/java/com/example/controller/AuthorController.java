package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.service.IAuthorAppService;
import com.example.dto.DtoAuthor;

@RestController
@RequestMapping("/rest/api/author")
public class AuthorController {
	
	@Autowired
	IAuthorAppService authorAppService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(path = "/save")
	public DtoAuthor saveAuthor(@RequestBody DtoAuthor dtoAuthor) {
		return authorAppService.save(dtoAuthor);
	}
	
	@GetMapping(path = "/list")
	public List<DtoAuthor> findAllAuthor() {
		return authorAppService.findAllAuthor();
	}
	
	
	@GetMapping(path = "/list/{id}")
	public DtoAuthor findDtoAuthorById(@PathVariable(name = "id",required = true) Long id) {
		return authorAppService.findAuthorById(id);
	}
}
