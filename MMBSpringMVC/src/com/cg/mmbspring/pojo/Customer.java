package com.cg.mmbspring.pojo;

public class Customer {
	private String customerName;
	private String emailId;
	private String dob;
	private String phoneNo;

	public Customer(String customerName, String emailId, String dob, String phoneNo) {
		super();
		this.customerName = customerName;
		this.emailId = emailId;
		this.dob = dob;
		this.phoneNo = phoneNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", emailId=" + emailId + ", dob=" + dob + ", phoneNo="
				+ phoneNo + "]";
	}

}
