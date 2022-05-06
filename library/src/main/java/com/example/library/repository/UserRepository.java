package com.example.library.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	

}
