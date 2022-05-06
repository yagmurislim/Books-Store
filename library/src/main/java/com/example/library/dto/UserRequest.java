package com.example.library.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
public class UserRequest {
	
	private String identity;
	
	private String fullName;
	
	private String password;
	
	@Email
	private String email;

	@NotBlank
	private String iban;
	
	private String phone;

	private String nfc;

	private UserType userType;
}
