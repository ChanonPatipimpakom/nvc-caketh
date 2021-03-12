package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Customer;
import utility.DBConnection;
import utility.MD5;

public class CustomerService {
	private ArrayList<Customer>lstCustomers = new ArrayList<Customer>();
	public CustomerService() {}
	
	public ArrayList<Customer> getLstCustomers() {
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn =dbConnection.getConnection();
			String sql ="SELECT * FROM customer";
			Statement statement =conn.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			while(rs.next()) {
				//process
				Customer c =new Customer();
				c.setId(rs.getInt("id"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setEmail(rs.getString("email"));
				c.setTel(rs.getString("tel"));
				c.setStatus(rs.getString("status"));
				lstCustomers.add(c);
			}
				rs.close();
				statement.close();
				conn.close();
				
		} catch (Exception e) {
			lstCustomers = null;
			System.out.println("CustomerService-> getLstCustomer():"+e.getMessage());
		}
		return lstCustomers;
	}
	
	public Customer getCustomer(int id) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="SELECT * FROM customer WHERE id=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1,id);
			ResultSet rs = statement.executeQuery();
			Customer customer = new Customer();
			
			while(rs.next())
			{
				customer.setId(rs.getInt("id"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("password"));
				customer.setStatus(rs.getString("status"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setEmail(rs.getString("email"));
				customer.setTel(rs.getString("tel"));	
			}
			rs.close();
			statement.close();
			conn.close();
			return customer;
			
		} catch (Exception e) {
			System.out.println("CustomerService->getLstCustomers():"+e.getMessage());
			return null;
		}
	}
	public boolean insertCustomer(Customer customer) {
		boolean inSuccess=false;
		
		try {
			String encPassword =MD5.getMd5(customer.getPassword());
			DBConnection dbConnection= new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="INSERT INTO customer(username,password,name,address,tel,email,status)VALUES(?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,customer.getUsername());
			statement.setString(2,encPassword);
			statement.setString(3,customer.getName());
			statement.setString(4,customer.getAddress());
			statement.setString(5,customer.getTel());
			statement.setString(6,customer.getEmail());
			statement.setString(7,customer.getStatus());
			int effectedRow=statement.executeUpdate();
			if(effectedRow!=0)
				inSuccess=true;
			else 
				inSuccess=false;
	    
			} catch (Exception e) {
			System.out.println("CustomerService->insertCustomer() :"+e.getMessage());
			inSuccess=false;
		}
		return inSuccess;
	}
	public boolean deleteCustomer(int id) {
		boolean isSuccess= true;
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn =dbConnection.getConnection();
			String sql ="DELETE FROM customer WHERE id =?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			int effectedRow = statement.executeUpdate();
			if(effectedRow!=0) {
				isSuccess =true;
			}
			else {
				isSuccess =false;
			}
		}catch (Exception e) { 
			System.out.println("CustomerService-> deleteCustomer():"+e.getMessage());
			isSuccess =false;
	}
		return isSuccess;	
	}
	public boolean updateCustomer (Customer customer) {
		boolean isSuccess =false;
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn =dbConnection.getConnection();
			String sql ="UPDATE customer SET username=?,name=?,address=?,email=?,tel=?,status=? WHERE id =?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, customer.getUsername());
			statement.setString(2, customer.getName());
			statement.setString(3, customer.getAddress());
			statement.setString(4, customer.getEmail());
			statement.setString(5, customer.getTel());
			statement.setString(6, customer.getStatus());
			statement.setInt(7, customer.getId());
			int effectedRow = statement.executeUpdate();
			if(effectedRow!=0)
				isSuccess =true;
			else {
				isSuccess =false;
			}
		}catch (Exception e) { 
			System.out.println("CustomerService-> updateCustomer():"+e.getMessage());
			isSuccess =false;
		}
		return isSuccess;
	}
}
