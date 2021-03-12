package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Order;
import model.Teacher;
import utility.DBConnection;

public class TeacherService {
	private ArrayList<Teacher> allTeach = new ArrayList<Teacher>();
	public TeacherService() {}
	
	public void setLstTeach(ArrayList<Teacher> lstTeach) {
		this.allTeach = lstTeach;
	}
	
	public Teacher getTeach(int id) {
		Teacher teach = new Teacher();
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="SELECT * FROM teacher WHERE id =?";
			PreparedStatement statement =conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				teach.setName(rs.getString("name"));
				teach.setId(rs.getInt("id"));
			}
		}catch (Exception e) {
			System.out.println("TeacherService-> getTeach():"+e.getMessage());
			teach = null;
		}
		
		return teach;
		
	}
	
	public ArrayList<Teacher> getAllTeach() {
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="SELECT * FROM teacher";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				//process
				Teacher te = new Teacher();
				te.setId(rs.getInt("id"));
				te.setName(rs.getString("name"));
				                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
				OrderService service = new OrderService();
				ArrayList<Order> orders = service.getOrdersFromTeacherId(rs.getInt("id"));
				te.setOrders(orders);
				allTeach.add(te); 
			}
				rs.close();
				statement.close();
				conn.close();
				
		} catch (Exception e) {
			allTeach = null;
			System.out.println("TeacherService-> getAllTeach():"+e.getMessage());
		}
		
		return allTeach;
	}
	
	public boolean insertTeacher(Teacher teach) {
		boolean inSuccess=false;
		
		try {
			DBConnection dbConnection= new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="INSERT INTO teacher(name)VALUES(?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,teach.getName());
			int effectedRow=statement.executeUpdate();
			if(effectedRow!=0)
				inSuccess=true;
			else 
				inSuccess=false;
	    
			} catch (Exception e) {
			System.out.println("TeacherService->insertTeacher() :"+e.getMessage());
			inSuccess=false;
		}
		
		return inSuccess;

	}
	
	public boolean updateTeach(Teacher teach) {
		boolean isSuccess =false;
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn =dbConnection.getConnection();
			String sql ="UPDATE teacher SET name=? WHERE id =?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, teach.getName());
			statement.setInt(2, teach.getId());
			int effectedRow = statement.executeUpdate();
			
			if(effectedRow!=0)
				isSuccess =true;
			else {
				isSuccess =false;
			}
		}catch (Exception e) { 
			System.out.println("TeacherService-> updateTeacher():"+e.getMessage());
			isSuccess =false;
			
		}
		return isSuccess;
	}
	
	public boolean deleteTeach(int id) {
		boolean isSuccess= true;
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="DELETE FROM teacher WHERE id = ?";
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
			System.out.println("TeacherService-> deleteTeacher():"+e.getMessage());
			isSuccess =false;
	}
		return isSuccess;	
	}
}
