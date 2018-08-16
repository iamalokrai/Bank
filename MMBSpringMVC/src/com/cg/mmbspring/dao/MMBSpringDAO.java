package com.cg.mmbspring.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mmbspring.pojo.BankAccount;
import com.cg.mmbspring.pojo.CurrentAccount;
import com.cg.mmbspring.pojo.Customer;
import com.cg.mmbspring.pojo.SavingAccount;

public class MMBSpringDAO {
	private Map<Integer, BankAccount> bankDb = new HashMap<>();
	CurrentAccount currentaccount;
	SavingAccount savingaccount;
	
	public void populateAccount() {
		bankDb.put(101, new SavingAccount(new Customer("Alok", "alokrai697@gmail.com", "02/07/1997", "8176955507"), 10000, true));
		bankDb.put(101, new SavingAccount(new Customer("Alok", "alokrai697@gmail.com", "02/07/1997", "8176955507"), 10000, true));
		bankDb.put(101, new CurrentAccount(new Customer("Alok", "alokrai697@gmail.com", "02/07/1997", "8176955507"), 10000, 1000));
		bankDb.put(101, new CurrentAccount(new Customer("Alok", "alokrai697@gmail.com", "02/07/1997", "8176955507"), 10000, 1000));
		
	}
	
	public int deposit(int accNo,int amount) {
		if(bankDb.containsKey(accNo)) {
			SavingAccount sa = null;
			CurrentAccount ca = null;
			if(bankDb.get(accNo).toString().contains("SavingsAccount")) {
				sa=(SavingAccount) bankDb.get(accNo);
				int bal = sa.getAccBalance();
				bal+=amount;
				sa.setAccBalance(bal);
				return sa.getAccBalance();
			}else {
				ca= (CurrentAccount) bankDb.get(accNo);
				int bal=ca.getAccBalance();
				bal+=amount;
				ca.setAccBalance(bal);
				return ca.getAccBalance();
			}
		}else {
			return 0;
		}
	}
	
	public int withdraw(int accNo,int amount) {
		if(bankDb.containsKey(accNo)) {
			SavingAccount sa = null;
			CurrentAccount ca = null;
			if(bankDb.get(accNo).toString().contains("SavingsAccount")) {
				sa=(SavingAccount) bankDb.get(accNo);
				int bal = sa.getAccBalance();
				if(bal>=amount) {
					bal-=amount;
					sa.setAccBalance(bal);
					return sa.getAccBalance();
				}else {
					return -1;
				}
				
			}else {
				ca= (CurrentAccount) bankDb.get(accNo);
				int bal=ca.getAccBalance();
				int odlim=ca.getOdLimit();
				if((bal+odlim)>amount) {
					bal+=amount;
					ca.setAccBalance(bal);
					return ca.getAccBalance();
				}else {
					return -1;
				}
				
			}
		}else {
			return -2;
		}
	}

}
