package com.bank;

public class BankAcc 
{
	private long accountNumber;
	private String name;
	private int balance;
	private int pin;
	

	public BankAcc(long accountNumber, String name, int balance, int pin) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.pin = pin;
	}
	
	public int getPin() {
		return pin;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Bank [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + ", pin=" + pin
				+ "]";
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	
	
	
	
}
