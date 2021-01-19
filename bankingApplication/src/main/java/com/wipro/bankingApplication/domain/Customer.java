package com.wipro.bankingApplication.domain;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
	
	private Integer id;
	
	@NotBlank (message = "Mobile number cannot be blank")
	@Size(max = 10, min = 10, message = "Should be 10 digits")
	private String primaryMobileNumber;
	@NotBlank(message = "Email Id cannot be Blank")
	@Email(message = "Email is not valid one")
	private String primaryEmailId;
	private String firstName;
	@NotNull
	private String lastName;
	private String middleName;
	private Account account;
	private LocalDateTime creationTime;
	public Customer(String firstName, @NotNull String lastName, String middleName, Account account) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.account = account;
		this.creationTime = LocalDateTime.now();
		
	}
	
	
}
