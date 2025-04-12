package com.example.infrastructure.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.model.Author;


public interface JpaAuthorRepository extends JpaRepository<Author, Long>{
	// HQL sorgularını yaz buraya: veya native sql de olabilir ? 
	
	@Query("SELECT a FROM Author a WHERE a.fullName =  :fullName")
	Author findAuthorByName(@Param("fullName") String name);
}
/*
 * 	@Query("SELECT s FROM Student s WHERE s.birthOfDate < :date")
	List<Student> getStudentsBornBefore(@Param("date") LocalDate date);
 */
