package com.cg.bankservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cg.bankservice.dto.CustomerDetails;
import com.cg.bankservice.utility.DataConnection;

public class BankFunctionDaoImpl implements BankFunctionDao {

	DataConnection dataConnection=new DataConnection();
	
	public long registerUser(CustomerDetails customerDetails) {
		long accountNo=0;
		Connection connection=dataConnection.connect();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("insert into customer_details values(ACCOUNT_SEQ_NO.nextval,?,?,?,?,?,?,?,?,?)");
			
			
			preparedStatement.setString(1, customerDetails.getFirstName());
			preparedStatement.setString(2, customerDetails.getLastName());
			preparedStatement.setString(3, customerDetails.getEmailId());
			preparedStatement.setString(4, customerDetails.getPassword());
			preparedStatement.setString(5, customerDetails.getPancardNo());
			preparedStatement.setLong(6, customerDetails.getAadharNo());
			preparedStatement.setLong(7, customerDetails.getMobileNo());
			preparedStatement.setString(8, customerDetails.getAddress());
			preparedStatement.setLong(9, customerDetails.getBalance());
			
			
			int i=preparedStatement.executeUpdate();
			
			if(i==1)
			{
					PreparedStatement statement=connection.prepareStatement("select * from customer_details where first_name=?");
			
					statement.setString(1, customerDetails.getFirstName());
					ResultSet resultSet=statement.executeQuery();
					while(resultSet.next())
					{
						accountNo=resultSet.getLong(1);
					}
			}		
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accountNo;
	}

	public long loginUser(long accountNo, String password) {
		
		long accNo=0;
		Connection connection=dataConnection.connect();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select * from customer_details where account_no=?");
			
			preparedStatement.setLong(1, accountNo);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				
				if(resultSet.getString(5).equals(password)) {
					accNo=accountNo;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accNo;
	}

}
