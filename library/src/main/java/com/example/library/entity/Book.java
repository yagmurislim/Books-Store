package com.example.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
	
	 @Id
	 @Column(name="isbn")
	 private String isbn;
	 private String author;
	 private String title;
	 private int pages;
	 @Column(name="publication_year")
	 private int year;
	 private double price;


}
