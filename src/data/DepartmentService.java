package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Department;
import model.Order;
import utility.DBConnection;

public class DepartmentService {
	private ArrayList<Department> allDepart = new ArrayList<Department>();
	public DepartmentService() {}
	
	public void setLstDepart(ArrayList<Department> lstDepart) {
		this.allDepart = lstDepart;
	}
	
	public Department getDepart(int id) {
		Department depart = new Department();
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="SELECT * FROM department WHERE id =?";
			PreparedStatement statement =conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				depart.setName(rs.getString("department"));
				depart.setId(rs.getInt("id"));
			}
		}catch (Exception e) {
			System.out.println("DepartmentService-> getDepart():"+e.getMessage());
			depart = null;
		}
		
		return depart;
		
	}
	
	public ArrayList<Department> getAllDepart() {
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="SELECT * FROM department";
			Statement statement =conn.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			while(rs.next()) {
				//process
				Department d = new Department();
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("department"));
				                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
				OrderService service = new OrderService();
				ArrayList<Order> orders = service.getOrdersFromDepartId(rs.getInt("id"));
				d.setOrders(orders);
				allDepart.add(d); 
			}
				rs.close();
				statement.close();
				conn.close();
				
		} catch (Exception e) {
			allDepart = null;
			System.out.println("DepartmentService-> getAllTeams():"+e.getMessage());
		}
		
		return allDepart;
	}
	
	public boolean insertDepartment(Department depart) {
		boolean inSuccess=false;
		
		try {
			DBConnection dbConnection= new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="INSERT INTO department(department)VALUES(?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,depart.getName());
			int effectedRow=statement.executeUpdate();
			if(effectedRow!=0)
				inSuccess=true;
			else 
				inSuccess=false;
	    
			} catch (Exception e) {
			System.out.println("DepartmentService->insertDepart() :"+e.getMessage());
			inSuccess=false;
		}
		
		return inSuccess;

	}
	
	public boolean updateDepart (Department depart) {
		boolean isSuccess =false;
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn =dbConnection.getConnection();
			String sql ="UPDATE department SET department=? WHERE id =?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, depart.getName());
			statement.setInt(2, depart.getId());
			int effectedRow = statement.executeUpdate();
			
			if(effectedRow!=0)
				isSuccess =true;
			else {
				isSuccess =false;
			}
		}catch (Exception e) { 
			System.out.println("DepartmentService-> updateDepartment():"+e.getMessage());
			isSuccess =false;
			
		}
		return isSuccess;
	}
	
	public boolean deleteDepart(int id) {
		boolean isSuccess= true;
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="DELETE FROM department WHERE id = ?";
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
			System.out.println("DepartmentService-> deleteDepartment():"+e.getMessage());
			isSuccess =false;
	}
		return isSuccess;	
	}
}
