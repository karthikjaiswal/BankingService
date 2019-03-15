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
		
		transacDetails.setFromAccountNo(1009l);
		
		
		assertEquals(transacDetails.getFromAccountNo(),(transactionDao.fundTransfer(1009l,1002l,10l)).getFromAccountNo());
	}
	
	@Test
	void testDepositAmount()
	{
		
		assertEquals(2000,transactionDao.depositAmount(1007l,0l));
	}
	@Test
	void testWithdrawAmount()
	{
		
		assertEquals(1000,transactionDao.withdrawAmount(1001l,0l));
	}
	@Test
	void testShowBalance()
	{
		
		assertEquals(2090,transactionDao.showBalance(1000l));
	}
	
}
