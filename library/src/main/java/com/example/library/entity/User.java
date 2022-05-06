package com.example.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class User {
	
	@Id
	@Column(name = "identity")
	private String identity;
	
	private String fullName;

	private String password;

	private String email;

	private String iban;

	private String phone;
	
	private String nfc;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private UserType userType;

}
