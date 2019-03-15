package com.cg.bankservice.service;

import com.cg.bankservice.dao.TransactionDao;
import com.cg.bankservice.dao.TransactionDaoImpl;
import com.cg.bankservice.dto.TransactionDetails;

public class TransactionServiceImpl implements TransactionService{

	TransactionDao transactionDao=new TransactionDaoImpl();
	public long depositAmount(long acc,long depositAmount) {
		// TODO Auto-generated method stub
		return transactionDao.depositAmount(acc,depositAmount);
	}

	public long withdrawAmount(long acc,long withdrawAmount) {
		// TODO Auto-generated method stub
		return transactionDao.withdrawAmount(acc,withdrawAmount);
	}

	public long showBalance(long accNo) {
		// TODO Auto-generated method stub
		return transactionDao.showBalance(accNo);
	}

	public TransactionDetails fundTransfer(long fromAcc, long toAcc, long amount) {
		// TODO Auto-generated method stub
		return transactionDao.fundTransfer(fromAcc, toAcc, amount);
	}

}
