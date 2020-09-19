package com.geeksforgeeks.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geeksforgeeks.app.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByAuthorName(String authorName);	
	List<Book> findByAuthorNameContaining(String str);
	List<Book> findByAuthorNameLike(String str);
}
