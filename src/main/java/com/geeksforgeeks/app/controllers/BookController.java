package com.geeksforgeeks.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geeksforgeeks.app.models.Book;
import com.geeksforgeeks.app.services.BookService;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

	@Autowired
	private BookService bokService;

	@Autowired
	private Environment environment;

	@GetMapping("/port")
	public String getPort() {
		return environment.getProperty("local.server.port");
	}

	@GetMapping("/allBooks")
	public ResponseEntity<List<Book>> getBooks() {
		return new ResponseEntity(this.bokService.getAllBooks(), HttpStatus.FOUND);
	}

	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return new ResponseEntity(this.bokService.addBook(book), HttpStatus.CREATED);
	}

	@PutMapping("/updateAuthor")
	public List<Book> updateAuthor(@RequestParam("fromName") String fromName,
			@RequestParam("toName") String toName) {
		return this.bokService.updateAuthorName(fromName, toName);
	}

	@DeleteMapping("/deleteBooks")
	public ResponseEntity<Book> deleteBooks() {
		return new ResponseEntity(this.bokService.deleteBooks(), HttpStatus.OK);
	}
}
