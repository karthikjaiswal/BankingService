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
	public boolean validateEmail(String email)
	{
		boolean check=true;
		
		
		return check;
		
	}

	public boolean validatePassword(String pass) {
		boolean check=true;
		
		
		return check;
	}

	public boolean validateAadhar(long aadhar) {
		boolean check=true;
		
		
		return check;
	}

	public boolean validateMobileNo(long mobile) {
		boolean check=true;
		
		
		return check;
	}

}
