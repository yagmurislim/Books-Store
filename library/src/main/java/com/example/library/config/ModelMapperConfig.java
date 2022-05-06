package com.example.library.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.library.dto.BookRequest;
import com.example.library.dto.BookResponse;

import com.example.library.dto.UserRequest;
import com.example.library.dto.UserResponse;
import com.example.library.entity.Book;
import com.example.library.entity.User;

@Configuration
public class ModelMapperConfig {
	private static final Converter<User, UserResponse> USER_TO_USER_RESPONSE_CONVERTER = 
			context -> new UserResponse(
					context.getSource().getIdentity(), 
					context.getSource().getFullName(), 
					context.getSource().getPassword(),
					context.getSource().getEmail(), 
					context.getSource().getIban(), 
					context.getSource().getPhone(),
					context.getSource().getNfc(), 
					context.getSource().getUserType());

	private static final Converter<UserRequest, User> USER_REQUEST_TO_USER_CONVERTER = 
			context -> new User(
					context.getSource().getIdentity(), 
					context.getSource().getFullName(), 
					context.getSource().getPassword(),
					context.getSource().getEmail(), 
					context.getSource().getIban(), 
					context.getSource().getPhone(),
					context.getSource().getNfc(), 
					context.getSource().getUserType());
			
			
//			private static final Converter<UpdateUserRequest, User> UPDATE_USER_REQUEST_TO_USER_CONVERTER = 
//					(context) -> {
//						
//						var updateCustReq = context.getSource();
//						var user = context.getDestination();
//						
//						user.setEmail(updateCustReq.getEmail());
//						user.setFullname(updateCustReq.);
//						
//						
//					};

	private static final Converter<Book, BookResponse> BOOK_TO_BOOK_RESPONSE_CONVERTER = 
			context -> new BookResponse(
					context.getSource().getIsbn(), 
					context.getSource().getAuthor(), 
					context.getSource().getTitle(),
					context.getSource().getPages(), 
					context.getSource().getYear(), 
					context.getSource().getPrice());

	private static final Converter<BookRequest, Book> BOOK_REQUEST_TO_BOOK_CONVERTER = 
			context -> new Book(
					context.getSource().getIsbn(), 
					context.getSource().getAuthor(), 
					context.getSource().getTitle(),
					context.getSource().getPages(), 
					context.getSource().getYear(), 
					context.getSource().getPrice());
			
			
			

	@Bean
	public ModelMapper mapper() {
		var mapper = new ModelMapper();
		mapper.addConverter(USER_TO_USER_RESPONSE_CONVERTER, User.class, UserResponse.class);
		mapper.addConverter(USER_REQUEST_TO_USER_CONVERTER, UserRequest.class, User.class);
		mapper.addConverter(BOOK_TO_BOOK_RESPONSE_CONVERTER, Book.class, BookResponse.class);
		mapper.addConverter(BOOK_REQUEST_TO_BOOK_CONVERTER, BookRequest.class, Book.class);
		return mapper;
	}

}
