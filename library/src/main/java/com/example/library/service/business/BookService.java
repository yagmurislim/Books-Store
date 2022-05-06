package com.example.library.service.business;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.library.dto.BookRequest;
import com.example.library.dto.BookResponse;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.IBookService;

@Service
public class BookService implements IBookService{

	private final BookRepository bookRepository;
	private ModelMapper modelMapper;
	
	public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
		this.bookRepository = bookRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public BookResponse findBookByIsbn(String isbn) {
		var result = modelMapper.map(
	 			bookRepository.findById(isbn).get(),
	 			BookResponse.class
	 	);
		
		return result;
	}


	@Override
	public BookResponse addBook(BookRequest book) {
		var addbook =  modelMapper.map(book , Book.class);
		var result = modelMapper.map(bookRepository.save(addbook),BookResponse.class);
		return result;
	}

	@Override
	public BookResponse updateBook(BookRequest book) {
		var updateBook = bookRepository.findById(book.getIsbn()).orElseThrow();
		modelMapper.map(book,updateBook);
		return modelMapper.map(bookRepository.save(updateBook), BookResponse.class); 
	}

	
	@Override
	public void deleteBook(String isbn) {
		bookRepository.deleteById(isbn);
		
	}


	


}
