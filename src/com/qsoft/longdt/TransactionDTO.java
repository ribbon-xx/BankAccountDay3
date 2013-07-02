package com.qsoft.longdt;

public class TransactionDTO {

	private String accountNumber;
	private long amount;
	private String description;
	private long timestamp;

	public TransactionDTO(String accountNumber, long amount, String description) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.description = description;
	}

	public TransactionDTO(String accountNumber, long amount,
			String description, long timestamp) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.description = description;
		this.timestamp = timestamp;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
