package com.cg.mmbspring.pojo;

public class CurrentAccount extends BankAccount {
	private int accBalance;
	private int odLimit;

	public CurrentAccount(Customer customer, int accBalance, int odLimit) {
		super(customer, "CurrentAccount");
		this.accBalance = accBalance;
		this.odLimit = odLimit;
	}

	public int getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(int accBalance) {
		this.accBalance = accBalance;
	}

	public int getOdLimit() {
		return odLimit;
	}

	public void setOdLimit(int odLimit) {
		this.odLimit = odLimit;
	}

}
