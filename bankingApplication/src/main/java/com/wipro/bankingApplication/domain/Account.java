package com.wipro.bankingApplication.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	private long accountNumber;
	private AccountType accountType;
	private LocalDateTime creationTimeStamp;
	private float currentAmount;
	public Account(AccountType accountType,  float currentAmount) {
		super();
		this.accountType = accountType;
		this.creationTimeStamp = LocalDateTime.now();
		this.currentAmount = currentAmount;
	}
	
	 
	
}

enum AccountType{
	SAVINGS,CURRENT
}
