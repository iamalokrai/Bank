package com.cg.mmbspring.service;

import com.cg.mmbspring.dao.MMBSpringDAO;

public class MMBSpringService {
	MMBSpringDAO dao = new MMBSpringDAO();
	
	public void populateAccount() {
		dao.populateAccount();
	}
	
	public int deposit(int accNo,int amount) {
		return dao.deposit(accNo, amount);
	}
	
	public int withdraw(int accNo,int amount) {
		return dao.withdraw(accNo, amount);
	}

}
