package com.beyondbanking.ssh.financialoverviewservice.model.dto;

import java.util.List;

public class Transactions {
	
	List<Transaction> transactions;

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
