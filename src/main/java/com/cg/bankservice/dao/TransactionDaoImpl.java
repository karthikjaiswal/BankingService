package com.cg.bankservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.bankservice.dto.TransactionDetails;
import com.cg.bankservice.utility.DataConnection;

public class TransactionDaoImpl implements TransactionDao{
	DataConnection dataConnection=new DataConnection();

	public long depositAmount(long acc,long depositAmount) {
		
		long depBal=0;
		Connection connection=dataConnection.connect();
		try {
			
			PreparedStatement preparedStatement=connection.prepareStatement("update customer_details set balance=balance+? where account_no=?");
			
			preparedStatement.setLong(1, depositAmount);
			preparedStatement.setLong(2, acc);
			
			int i=preparedStatement.executeUpdate();
			if(i==1)
			{
				PreparedStatement statement=connection.prepareStatement("select * from customer_details where account_no=?");
				
				statement.setLong(1, acc);
				ResultSet resultSet=statement.executeQuery();
				while(resultSet.next())
				{
					depBal=resultSet.getLong(10);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return depBal;
	}

	public long withdrawAmount(long acc,long withdrawAmount) {
		long witBal=0;
		Connection connection=dataConnection.connect();
		try {
			
			PreparedStatement preparedStatement=connection.prepareStatement("update customer_details set balance=balance-? where account_no=? and balance > ?");
			
			preparedStatement.setLong(1,withdrawAmount);
			preparedStatement.setLong(2, acc);
			preparedStatement.setLong(3, withdrawAmount);
			
			int i=preparedStatement.executeUpdate();
			if(i==1)
			{
				PreparedStatement statement=connection.prepareStatement("select * from customer_details where account_no=?");
				
				statement.setLong(1, acc);
				ResultSet resultSet=statement.executeQuery();
				while(resultSet.next())
				{
					witBal=resultSet.getLong(10);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return witBal;
	}

	public long showBalance(long accNo) {
		
		long bal=0;
		Connection connection=dataConnection.connect();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("select * from customer_details where account_no=?");
			statement.setLong(1, accNo);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				bal=resultSet.getLong(10);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bal;
	}

	public TransactionDetails fundTransfer(long fromAcc, long toAcc, long amount) {
		
		Connection connection=dataConnection.connect();
		TransactionDetails transactionDetails=new TransactionDetails();
		
		
		if(validateAccount(toAcc))
		{
					try {
						
						PreparedStatement preparedStatement=connection.prepareStatement("update customer_details set balance=balance-? where account_no=? and balance > ?");
						
						preparedStatement.setLong(1, amount);
						preparedStatement.setLong(2, fromAcc);
						preparedStatement.setLong(3, amount);
						
						int i=preparedStatement.executeUpdate();
						
						if(i==1)
						{
							PreparedStatement preparedStatement2=connection.prepareStatement("update customer_details set balance=balance+? where account_no=?");
							
							preparedStatement2.setLong(1, amount);
							preparedStatement2.setLong(2, toAcc);
							
							int j=preparedStatement2.executeUpdate();
							if(j==1)
							{
								PreparedStatement preparedStatement3=connection.prepareStatement("insert into transaction_details values(TRANSACTION_SEQ_NO.nextval,?,?,?)");
								
								preparedStatement3.setLong(1, fromAcc);
								preparedStatement3.setLong(2, toAcc);
								preparedStatement3.setLong(3, amount);
								
								int k=preparedStatement3.executeUpdate();
								if(k==1)
								{
									PreparedStatement preparedStatement4=connection.prepareStatement("select * from transaction_details where from_account_no=?");
									
									preparedStatement4.setLong(1, fromAcc);
									
									ResultSet resultSet=preparedStatement4.executeQuery();
									while(resultSet.next())
									{
										transactionDetails.setTransactionId(resultSet.getLong(1));
										transactionDetails.setFromAccountNo(resultSet.getLong(2));
										transactionDetails.setToAccountNo(resultSet.getLong(3));
										transactionDetails.setAmountTransfered(resultSet.getLong(4));
										
										
									}
									
									
									
								}
								
							}
							
						}
						
						
						
						
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
					
		}
		return transactionDetails;
		}

	public boolean validateAccount(long acc) {
		boolean check=false;
		Connection connection=dataConnection.connect();
		Statement statement;
		try {
			statement = connection.createStatement();
			
			ResultSet resultSet=statement.executeQuery("select * from customer_details");
			while(resultSet.next())
			{
				if(resultSet.getLong(1)==acc)
				{
					check=true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

}
