package com.cg.mmbspring.pojo;

public class BankAccount {
	Customer customer;
	private int accountNumber;
	static int accId = 100;
	private String accType;

	public BankAccount(Customer customer, String accType) {
		super();
		accountNumber = accId + 1;
		this.customer = customer;
		this.accType = accType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public static int getAccId() {
		return accId;
	}

	public static void setAccId(int accId) {
		BankAccount.accId = accId;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

}
