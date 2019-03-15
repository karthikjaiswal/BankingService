package com.cg.bankservice.service;

import com.cg.bankservice.dto.CustomerDetails;

public interface BankFunctionService {
	long registerUser(CustomerDetails customerDetails);
	long loginUser(long accountNo,String password);
	boolean validateAadhar(long aadhar);
	boolean validateMobileNo(long mobile);
	
	
}
