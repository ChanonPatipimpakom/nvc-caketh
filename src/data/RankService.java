package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Rank;
import utility.DBConnection;

public class RankService {
	private ArrayList<Rank> lstRanks = new ArrayList<Rank>();
	public RankService() {}
	
	public ArrayList<Rank> getLstRanks() {
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn =dbConnection.getConnection();
			String sql ="SELECT team.id,team.name,SUM(orderdetails.pound*orderdetails.quantity)"
					+ "As total FROM `orders`,`orderdetails`,`team` WHERE orders.orderId=orderdetails.orderId AND "
					+ "orders.teamId=team.id AND orders.status=1 GROUP BY team.id";
			Statement statement =conn.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			while(rs.next()) {
				//process
				Rank r =new Rank();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
				r.setTotal(rs.getInt("total"));
				lstRanks.add(r);
				
			}
				rs.close();
				statement.close();
				conn.close();
				
		} catch (Exception e) {
			lstRanks = null;
			System.out.println("RankService-> getLstRank():"+e.getMessage());
		}
		
		return lstRanks;
	}
}
