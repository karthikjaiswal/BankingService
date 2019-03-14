package com.cg.bankservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.bankservice.utility.DataConnection;

import oracle.jdbc.proxy.annotation.Pre;

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

	public long fundTransfer(long fromAcc, long toAcc, long amount) {
		long transId=0;
		Connection connection=dataConnection.connect();
		if(validateAccount(toAcc))
		{
					try {
						PreparedStatement preparedStatement=connection.prepareStatement("");
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
					
		}
		return transId;
		}

	public boolean validateAccount(long acc) {
		boolean check=false;
		Connection connection=dataConnection.connect();
		PreparedStatement preparedStatement1;
		try {
			preparedStatement1 = connection.prepareStatement("select * from customer_details");
			preparedStatement1.setLong(1,acc);
			ResultSet resultSet=preparedStatement1.executeQuery();
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
