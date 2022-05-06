package com.example.library.dto;

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
public class BookResponse {

	private String isbn;
	private String author;
	private String title;
	private int pages;
	private int year;
	private double price;

}
