package com.qsoft.longdt;

import java.util.Calendar;

public class BankAccount {

	private BankAccountDAO baDAO;
	private TransactionDAO tDAO;
	private Calendar cal;

	public void setBaDAO(BankAccountDAO baDAO) {
		this.baDAO = baDAO;
	}

	public void setTDAO(TransactionDAO tDAO) {
		this.tDAO = tDAO;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public BankAccountDTO openAccount(String accountNumber) {
		BankAccountDTO baDTO = new BankAccountDTO();
		baDTO.setAccountNumber(accountNumber);
		baDTO.setBalance(0l);
		baDTO.setTimeStamp(cal.getTimeInMillis());
		baDAO.doCreate(baDTO);
		return baDTO;
	}

	public BankAccountDTO getAccount(String accountNumber) {
		return baDAO.doRead(accountNumber);
	}

	public void deposit(String accountNumber, long amount, String description) {
		BankAccountDTO baDTO = getAccount(accountNumber);
		baDTO.setBalance(baDTO.getBalance() + amount);
		baDTO.setDescription(description);
		baDAO.doUpdate(baDTO);
	}

	public void deposite(BankAccountDTO accountDTO, long amount,
			String description) {
		long newBalance = (long) (accountDTO.getBalance() + amount);
		accountDTO.setBalance(newBalance);
		accountDTO.setDescription(description);
		baDAO.doUpdate(accountDTO);
		Transaction trans = new Transaction();
		trans.setTransactionDao(tDAO);
		trans.createTransaction(accountDTO.getAccountNumber(), amount,
				description);
	}

	public void withDraw(BankAccountDTO accountDTO, long amount,
			String description) {
		long newBalance = (long) (accountDTO.getBalance() - amount);
		accountDTO.setBalance(newBalance);
		accountDTO.setDescription(description);
		baDAO.doUpdate(accountDTO);
		Transaction trans = new Transaction();
		trans.setTransactionDao(tDAO);
		trans.createTransaction(accountDTO.getAccountNumber(), amount,
				description);
	}

}
