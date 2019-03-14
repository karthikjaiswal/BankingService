package com.cg.bankservice.dao;

public interface TransactionDao {
	long depositAmount(long acc,long depositAmount);
	long withdrawAmount(long acc,long withdrawAmount);
	long showBalance(long accNo);
	long fundTransfer(long fromAcc,long toAcc,long amount);
	boolean validateAccount(long acc);
}
