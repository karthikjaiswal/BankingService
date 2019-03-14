package com.cg.bankservice;

import java.util.Scanner;

import com.cg.bankservice.dto.CustomerDetails;
import com.cg.bankservice.service.BankFunctionService;
import com.cg.bankservice.service.BankFunctionServiceImpl;
import com.cg.bankservice.service.TransactionService;
import com.cg.bankservice.service.TransactionServiceImpl;

public class Bank 
{
    public static void main( String[] args )
    {
    	Scanner scanner =new Scanner(System.in);
    	BankFunctionService bankFunctionService=new BankFunctionServiceImpl();
    	TransactionService transactionService=new TransactionServiceImpl();
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
		        		customerDetails.setAadharNo(scanner.nextLong());
		        		
		        		System.out.println("enter mobile no");
		        		customerDetails.setMobileNo(scanner.nextLong());
		        		
		        		System.out.println("enter address");
		        		customerDetails.setAddress(scanner.next());
		        		
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
		        			System.out.println("Enter option:");
		        			System.out.println("1.Deposit \n2.Withdraw \n3.show balance \n4.fund transfer");
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
		        					break;
		        				case 2:
				        					System.out.println("Enter withdraw amount:");
				        					long witBal=transactionService.withdrawAmount(acc,scanner.nextLong());
				        					if(witBal!=0)
				        						System.out.println("balance after deposit:"+witBal);
				        					else
				        						System.err.println("ERROR depositing");
		        					break;
		        				case 3:
		        							System.out.println("Enter account number");
		        							long bal=transactionService.showBalance(scanner.nextLong());
		        							if(bal!=0)
				        						System.out.println("balance after deposit:"+bal);
				        					else
				        						System.err.println("ERROR depositing");
		        					break;
		        				case 4:
		        							System.out.println("Enter to-Account-No: ");
		        							long toAcc=scanner.nextLong();
		        							System.out.println("Enter amount to transfer:");
		        							long amount=scanner.nextLong();
		        							
		        							long transId=transactionService.fundTransfer(acc, toAcc, amount);
		        							if(transId!=0)
		        								System.out.println("Fund transfered successfully with transaction id:"+transId);
		        							else
		        								System.err.println("ERROR transfering");
		        					break;
		        				default:
		        					break;
		        					
		        			}
		        			
		        			
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
}
