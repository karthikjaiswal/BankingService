package com.cg.bankservice.service;

public interface TransactionService {

	long depositAmount(long acc,long depositAmount);
	long withdrawAmount(long acc,long withdrawAmount);
	long showBalance(long accNo);
	long fundTransfer(long fromAcc,long toAcc,long amount);
}
