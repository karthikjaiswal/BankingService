package com.cg.bankservice.dao;

import com.cg.bankservice.dto.TransactionDetails;

public interface TransactionDao {
	long depositAmount(long acc,long depositAmount);
	long withdrawAmount(long acc,long withdrawAmount);
	long showBalance(long accNo);
	TransactionDetails fundTransfer(long fromAcc,long toAcc,long amount);
	boolean validateAccount(long acc);
}
