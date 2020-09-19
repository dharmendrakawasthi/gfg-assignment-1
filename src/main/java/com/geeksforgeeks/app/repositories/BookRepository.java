package com.geeksforgeeks.app.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.geeksforgeeks.app.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByAuthorNameLike(String str);
	
	@Modifying
	@Transactional
	@Query(value = "delete from book where cost > 1000", nativeQuery = true)
	Integer deleteBooks();
}
