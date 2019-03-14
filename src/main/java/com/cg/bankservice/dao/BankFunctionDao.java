package com.cg.bankservice.dao;

import com.cg.bankservice.dto.CustomerDetails;

public interface BankFunctionDao {

	long registerUser(CustomerDetails customerDetails);
	long loginUser(long accountNo,String password);
}
