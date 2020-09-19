package com.geeksforgeeks.app.services;

import java.util.List;

import com.geeksforgeeks.app.models.Book;

public interface BookService {

	public List<Book> getAllBooks();
	public Book addBook(Book book);
	public List<Book> updateAuthor();
}
