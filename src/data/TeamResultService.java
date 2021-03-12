package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.TeamResult;
import utility.DBConnection;

public class TeamResultService {
	private ArrayList<TeamResult> results = new ArrayList<TeamResult>();
	
	public ArrayList<TeamResult> getTeamRank(){
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn =dbConnection.getConnection();
			String sql ="SELECT t.name,SUM(d.quantity * d.pound) AS TotalPound " + 
					"FROM team t INNER JOIN orders o ON t.id = o.teamId " + 
					"INNER JOIN orderdetails d ON o.orderId = d.orderId  " + 
					"WHERE t.id <> 1 AND o.status =1 " +
					"GROUP BY t.name " + 
					"ORDER BY SUM(d.quantity * d.pound) DESC";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				TeamResult t = new TeamResult();
				t.setName(rs.getString("name"));
				t.setTotalPound(rs.getInt("totalpound"));
				results.add(t);
			}
			rs.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("TeamResultService>>getTeamRank(): " + e.getMessage());
			results =  null;
		}		
		return results;
	}
}
