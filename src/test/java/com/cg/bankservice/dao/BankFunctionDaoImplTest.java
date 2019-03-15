package com.cg.bankservice.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.bankservice.dto.CustomerDetails;

class BankFunctionDaoImplTest {

	static BankFunctionDaoImpl backDao;
	static CustomerDetails customer;

	@BeforeAll
	public static void init()
	{
		backDao=new BankFunctionDaoImpl();
		customer=new CustomerDetails();
	}
	
	@Test
	void testRegisterUser() {
		
		customer.setFirstName("akshita");
		customer.setLastName("Reddy");
		customer.setEmailId("reddy@gmail");
		customer.setPassword("12345");
		customer.setAadharNo(548756124589l);
		customer.setPancardNo("aksr45");
		customer.setMobileNo(8745645568l);
		customer.setAddress("Hyderabad");
		customer.setBalance(0);
		
		assertEquals(1012, backDao.registerUser(customer));
	}
	
	@Test
	void testLoginUser()
	{
		
		assertEquals(1001, backDao.loginUser(1001, "1245"));
	}

}
