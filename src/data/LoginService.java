package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Customer;
import utility.DBConnection;
import utility.MD5;

public class LoginService {

	public Customer login(String username,String password) {
		try {
			String encPassword =MD5.getMd5(password);
			DBConnection dbConnection = new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql = "SELECT id FROM customer WHERE username=? AND password=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, encPassword);
			ResultSet rs = statement.executeQuery();
			Customer customer = new Customer();
			if(rs.next()) 
			{
				customer = new CustomerService().getCustomer(rs.getInt("id"));
			}
			else
			{
				customer= null;
			}
			rs.close();
			statement.close();
			conn.close();
			return customer;
		} catch (Exception e) {
			System.out.println("LoginService>>login():"+e.getMessage());
			return null;
		}
		
		
	}
}
