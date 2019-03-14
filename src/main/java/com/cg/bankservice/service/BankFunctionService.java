package com.cg.bankservice.service;

import com.cg.bankservice.dto.CustomerDetails;

public interface BankFunctionService {
	long registerUser(CustomerDetails customerDetails);
	long loginUser(long accountNo,String password);
	boolean validateEmail(String email);
	boolean validatePassword(String pass);
	boolean validateAadhar(long aadhar);
	boolean validateMobileNo(long mobile);
	
	
}
