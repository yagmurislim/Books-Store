package com.example.library.controller;

import javax.transaction.Transactional;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.library.dto.BookRequest;
import com.example.library.dto.BookResponse;
import com.example.library.service.IBookService;

import lombok.Data;

@RestController
@RequestScope
@RequestMapping("/books")
@CrossOrigin
@Validated
@Data
@Transactional
public class BookController {
	
	private final IBookService bookService;
	

	@GetMapping("/{isbn}")
	public BookResponse findBookByIsbn(@PathVariable String isbn) {
		return bookService.findBookByIsbn(isbn);
	}
	
	@DeleteMapping("{isbn}")
	public void  deleteBookByIsbn(@PathVariable String isbn) {
		 bookService.deleteBook(isbn);
	}
	

	@PostMapping
	public BookResponse addBookByIsbn(@RequestBody BookRequest book ) {
		return bookService.addBook(book);
	}

	@PutMapping
	public BookResponse updateBookByIsbn(@RequestBody BookRequest book) {
		return bookService.updateBook(book);
	}

}
