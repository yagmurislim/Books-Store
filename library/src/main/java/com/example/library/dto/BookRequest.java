package com.example.library.dto;

import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequest {
	
	
	private String isbn;
	@NotBlank
	private String author;
	@NotBlank
	private String title;
	@NotBlank
	private int pages;
	@NotBlank
	private int year;
	@NotBlank
	private double price;

}
