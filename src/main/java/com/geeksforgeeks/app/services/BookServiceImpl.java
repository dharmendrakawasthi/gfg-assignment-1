package com.geeksforgeeks.app.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geeksforgeeks.app.models.Book;
import com.geeksforgeeks.app.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return this.bookRepository.findAll();
	}

	@Override
	public Book addBook(Book book) {
		book.setCreatedDate(new Timestamp(new Date().getTime()));
		return this.bookRepository.save(book);
	}

	@Override
	public List<Book> updateAuthorName(String fromName, String toName) {
		return this.bookRepository.findByAuthorNameLike(fromName+"%")
				.stream()
				.filter(b -> b.getAuthorName().split(" ")[0].equals(fromName))
				.map(book -> {
					book.setAuthorName(toName + " " + book.getAuthorName().split(" ")[1]);
					return this.bookRepository.save(book);
					}
				)
				.collect(Collectors.toList());
	}

	@Override
	public Integer deleteBooks() {
		return this.bookRepository.deleteBooks();
	}
}
