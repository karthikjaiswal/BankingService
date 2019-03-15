package com.cg.bankservice;

import java.util.Scanner;

import com.cg.bankservice.dto.CustomerDetails;
import com.cg.bankservice.dto.TransactionDetails;
import com.cg.bankservice.service.BankFunctionService;
import com.cg.bankservice.service.BankFunctionServiceImpl;
import com.cg.bankservice.service.TransactionService;
import com.cg.bankservice.service.TransactionServiceImpl;

public class Bank 
{
	static TransactionService transactionService=new TransactionServiceImpl();
	static TransactionDetails transactionDetails=new TransactionDetails();
	static Scanner scanner =new Scanner(System.in);
    public static void main( String[] args )
    {
    	
    	BankFunctionService bankFunctionService=new BankFunctionServiceImpl();
    	
    	CustomerDetails customerDetails=new CustomerDetails();
    	
    	
    	
        while(true)
        {
        	System.out.println("=======Online Banking============");
        	System.out.println("1. Register \n2. Login \n3. Exit");
        	int choice=scanner.nextInt();
        	switch(choice)
        	{
		        	case 1:
		        		System.out.println("enter first name");
		        		customerDetails.setFirstName(scanner.next());
		        		
		        		System.out.println("enter last name");
		        		customerDetails.setLastName(scanner.next());
		        		
		        		System.out.println("enter email");
		        		customerDetails.setEmailId(scanner.next());
		
		        		System.out.println("enter password");
		        		customerDetails.setPassword(scanner.next());
		
		        		System.out.println("enter pancard no");
		        		customerDetails.setPancardNo(scanner.next());
		        		
		        		System.out.println("enter aadhar no");
		        		long aadhar=scanner.nextLong();
		        		if(bankFunctionService.validateAadhar(aadhar))
		        		{
		        			customerDetails.setAadharNo(aadhar);
		        			System.out.println("enter mobile no");
			        		long mobile=scanner.nextLong();
			        		if(bankFunctionService.validateMobileNo(mobile))
			        		{
			        			customerDetails.setMobileNo(mobile);
			        			System.out.println("enter address");
				        		customerDetails.setAddress(scanner.next());
			        		}
		        			
		        		}
		        		else
		        		{
		        			System.err.println("Invalid Aadhar or Mobile Number");
		        		}
		        		
		        		customerDetails.setBalance(0);
		        		
		        		long accountNo=bankFunctionService.registerUser(customerDetails);
		        		if(accountNo!=0)
		        			System.out.println("Successfully registered with account number: "+accountNo);
		        		else
		        			System.err.println("ERROR registering");
		        		
		        		break;
		        	case 2:
		        		System.out.println("Enter account number:");
		        		long accNo=scanner.nextLong();
		        		System.out.println("Enter password:");
		        		String pass=scanner.next();
		        		
		        		long acc=bankFunctionService.loginUser(accNo, pass);
		        		if(acc!=0)
		        		{
		        				performOperations(acc);	
		        			
		        		}
		        		else
		        		{
		        			System.err.println("ERROR: LOGIN FAILED");
		        		}
		        		
		        		break;
		        	case 3:
		        		scanner.close();
		        		System.exit(0);
        	}
        }
    }
    public static void performOperations(long acc)
	{
    	System.out.println("======Bank Operation=====");
		System.out.println("1.Deposit \n2.Withdraw \n3.show balance \n4.fund transfer \n5.exit");
		int option=scanner.nextInt();
		switch(option)
		{
			case 1:
    					System.out.println("Enter deposit amount:");
    					long depBal=transactionService.depositAmount(acc,scanner.nextLong());
    					if(depBal!=0)
    						System.out.println("balance after deposit:"+depBal);
    					else
    						System.err.println("ERROR depositing");
    					
    					performOperations(acc);
				break;
			case 2:
    					System.out.println("Enter withdraw amount:");
    					long witBal=transactionService.withdrawAmount(acc,scanner.nextLong());
    					if(witBal!=0)
    						System.out.println("balance after deposit:"+witBal);
    					else
    						System.err.println("ERROR depositing");
    					
    					performOperations(acc);
				break;
			case 3:
						long bal=transactionService.showBalance(acc);
						if(bal!=0)
    						System.out.println("balance after deposit:"+bal);
    					else
    						System.err.println("ERROR depositing");
						
						performOperations(acc);
				break;
			case 4:
						System.out.println("Enter to-Account-No: ");
						long toAcc=scanner.nextLong();
						System.out.println("Enter amount to transfer:");
						long amount=scanner.nextLong();
						
						transactionDetails=transactionService.fundTransfer(acc, toAcc, amount);
						if(transactionDetails!=null)
						{
							System.out.println("========printing transaction==========");
		    				System.out.println("Transaction Id: "+transactionDetails.getTransactionId());
		    				System.out.println("From Account No: "+transactionDetails.getFromAccountNo());
		    				System.out.println("To Account No: "+transactionDetails.getToAccountNo());
		    				System.out.println("Amount Transfered: "+transactionDetails.getAmountTransfered());
		    				
						}
						else
							System.err.println("ERROR transfering");
						
						performOperations(acc);
				break;
			case 5:
				
					break;
			default: 
				System.err.println("Invalid operation");
				break;
				
		}
	}
}
