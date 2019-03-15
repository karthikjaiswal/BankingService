package com.cg.bankservice.service;

import com.cg.bankservice.dao.BankFunctionDao;
import com.cg.bankservice.dao.BankFunctionDaoImpl;
import com.cg.bankservice.dto.CustomerDetails;

public class BankFunctionServiceImpl implements BankFunctionService{

	BankFunctionDao bankFunctionDao=new BankFunctionDaoImpl();
	public long registerUser(CustomerDetails customerDetails) {
		
		return bankFunctionDao.registerUser(customerDetails);
		
		
	}

	public long loginUser(long accountNo, String password) {
			
		return bankFunctionDao.loginUser(accountNo, password);
	}
	
	public boolean validateAadhar(long aadhar) {
		String mob=String.valueOf(aadhar);
		if(mob.length()==12)
			return true;
		else
			return false;
	}

	public boolean validateMobileNo(long mobile) {
		
		String mob=String.valueOf(mobile);
		if(mob.length()==10)
			return true;
		else
			return false;
	
	}

}
