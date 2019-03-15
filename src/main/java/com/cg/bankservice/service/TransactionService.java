package com.cg.bankservice.service;

import com.cg.bankservice.dto.TransactionDetails;

public interface TransactionService {

	long depositAmount(long acc,long depositAmount);
	long withdrawAmount(long acc,long withdrawAmount);
	long showBalance(long accNo);
	TransactionDetails fundTransfer(long fromAcc,long toAcc,long amount);
}
