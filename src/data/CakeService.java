package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cake;
import utility.DBConnection;

public class CakeService {
	private ArrayList<Cake> lstCake = new ArrayList<Cake>();
	public CakeService() {}
	
	public Cake getCake(int cakeid) {
		
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn =dbConnection.getConnection();
			String sql ="SELECT * FROM cake WHERE id =?";
			PreparedStatement statement =conn.prepareStatement(sql);
			statement.setInt(1, cakeid);
			ResultSet rs =statement.executeQuery();
			Cake cake =new Cake();
			while(rs.next()) {
				cake.setName(rs.getString("Name"));
				cake.setId(rs.getInt("id"));
				cake.setPricePerPound(rs.getFloat("pricePerPound"));
				cake.setDiscountRate(rs.getFloat("discountRate"));
			}
			rs.close();
			statement.close();
			conn.close();
			return cake;
		}catch (Exception e) {
			System.out.println("CakeService-> getCake():"+e.getMessage());
			return  null;
		}
		
	}
	public ArrayList<Cake>getLstCakes(){
		try {
			DBConnection dbConnection =new DBConnection();
		Connection conn =dbConnection.getConnection();
		String sql ="SELECT * FROM cake";
		Statement statement =conn.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		while(rs.next()) {
			//process
			Cake c =new Cake();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setPricePerPound(rs.getFloat("pricePerPound"));
			c.setDiscountRate(rs.getFloat("discountRate"));
			lstCake.add(c);
			
		} 
		rs.close();
		statement.close();
		conn.close();
		
			
		}catch (Exception e) {
			lstCake = null;
			System.out.println("CakeService-> getLstCake():"+e.getMessage());
		}
		return lstCake;
	}
	public void setLstCakes(ArrayList<Cake> lstCakes) {
		this.lstCake = lstCakes;
	}
	public boolean insertCake(Cake cake) {
		boolean inSuccess=false;
		
		try {
			DBConnection dbConnection= new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="INSERT INTO cake(name,pricePerPound,discountRate)VALUES(?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,cake.getName());
			statement.setFloat(2, cake.getPricePerPound());
			statement.setFloat(3, cake.getDiscountRate());
			int effectedRow=statement.executeUpdate();
			if(effectedRow!=0)
				inSuccess=true;
			else 
				inSuccess=false;
			} catch (Exception e) {
			System.out.println("CakeService->insertCake() :"+e.getMessage());
			inSuccess=false;
		}
		return inSuccess;
	}
	public boolean deleteCake(int id) {
		boolean isSuccess= true;
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn =dbConnection.getConnection();
			String sql ="DELETE FROM cake WHERE id =?";
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
			System.out.println("CakeService-> deleteCake():"+e.getMessage());
			isSuccess =false;
	}
		return isSuccess;	
	}
	public boolean updateCake (Cake cake) {
		boolean isSuccess =false;
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn =dbConnection.getConnection();
			String sql ="UPDATE cake SET name=?,pricePerPound=?,discountRate=? WHERE id =?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cake.getName());
			statement.setFloat(2, cake.getPricePerPound());
			statement.setFloat(3, cake.getDiscountRate());
			statement.setInt(4, cake.getId());
			int effectedRow = statement.executeUpdate();
			if(effectedRow!=0)
				isSuccess =true;
			else {
				isSuccess =false;
			}
		}catch (Exception e) { 
			System.out.println("CakeService-> updateCake():"+e.getMessage());
			isSuccess =false;
		}
		return isSuccess;
	}
}
