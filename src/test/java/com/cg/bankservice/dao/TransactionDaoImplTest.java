package com.cg.bankservice.dao;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.bankservice.dto.TransactionDetails;

class TransactionDaoImplTest {

	static TransactionDaoImpl transactionDao;
	static TransactionDetails transacDetails;
	@BeforeAll
	public static void init()
	{
		transactionDao=new TransactionDaoImpl();
		transacDetails=new TransactionDetails();
	}
	@Test
	void testFundTransfer()
	{
		transacDetails.setTransactionId(105);
		transacDetails.setFromAccountNo(1002l);
		transacDetails.setToAccountNo(1009l);
		transacDetails.setAmountTransfered(100l);
		
		assertEquals(transacDetails,transactionDao.fundTransfer(1002l,1009l,100l));
	}
	
	@Test
	void testDepositAmount()
	{
		
		assertEquals(2000,transactionDao.depositAmount(1007l,0l));
	}
	@Test
	void testWithdrawAmount()
	{
		
		assertEquals(1000,transactionDao.withdrawAmount(1001l,100l));
	}
	@Test
	void testShowBalance()
	{
		
		assertEquals(2090,transactionDao.showBalance(1000l));
	}
	
}
