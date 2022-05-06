package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	void deleteByIsbn(String isbn);

}
