package com.example.library.service;

import com.example.library.dto.BookRequest;
import com.example.library.dto.BookResponse;

public interface IBookService {

	BookResponse findBookByIsbn(String isbn);

	BookResponse updateBook(BookRequest book);

	void deleteBook(String isbn);

	BookResponse addBook(BookRequest book);

}
