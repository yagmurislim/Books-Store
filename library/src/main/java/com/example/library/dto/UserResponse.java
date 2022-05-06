package com.example.library.dto;

import javax.persistence.Column;

import com.example.library.entity.UserType;

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
public class UserResponse {
	private String identity;
	private String fullName;
	@Column(nullable = false)
	private String password;
	private String email;
	private String iban;
	private String phone;

	@Column(unique = true)
	private String nfc;

	private UserType type;
}
