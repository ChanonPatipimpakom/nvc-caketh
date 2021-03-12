package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cake;
import model.OrderDetail;
import utility.DBConnection;

public class OrderDetailService {
	private ArrayList<OrderDetail> lstOrderDetails = new ArrayList<OrderDetail>();

	public OrderDetailService() {}
	
	/*public OrderDetail getOrdersDetil(int id) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="SELECT * FROM orderdetails WHERE id=?";
			PreparedStatement statement =conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			OrderDetail ordersDetil = new OrderDetail();
			
			while (rs.next()) {
				ordersDetil.setId(rs.getInt("id"));
				ordersDetil.setOrder(rs.getInt("order"));
				ordersDetil.setCake(rs.getInt("cake"));
				ordersDetil.setPound(rs.getInt("pound"));
				ordersDetil.setQuantity(rs.getInt("quantity"));
				
			}rs.close();
			statement.close();
			conn.close();
			return ordersDetil;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("OrderDetilService->getOrderDetil():"+e.getMessage());
		return null;
		}
	}
	*/
public ArrayList <OrderDetail> getOrderDetailsFromOrderId (int orderId){
		try {
			ArrayList<Cake> allCakes = new CakeService().getLstCakes();
			for(Cake c: allCakes) {
				for(int p =1;p<=5;p++) {
					OrderDetail detail = new OrderDetail();
					detail = getOrderDetailFromCake(orderId, c.getId(), p);
					lstOrderDetails.add(detail);
				}
			}
		} catch (Exception e) {
			lstOrderDetails = null;
			System.out.println("OrderDetailService -> getOrderDetailsFromOrderId()"+ e.getMessage());
			// TODO: handle exception
		}
		return lstOrderDetails;		
	}
	public boolean insertOrdersDetail(OrderDetail ordersDetail) {
		boolean isSuccess = false;
		try {
			DBConnection dbConnection = new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql = "INSERT INTO orderdetails (orderId, cakeId, pound,quantity)VALUES(?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);		
			statement.setInt(1,ordersDetail.getOrderId());
			statement.setInt(2,ordersDetail.getCake().getId());
			statement.setInt(3,ordersDetail.getPound());
			statement.setInt(4,ordersDetail.getQuantity());
			
			int effectedRow = statement.executeUpdate();
			
			if (effectedRow !=0 ) 
				isSuccess = true;
			else
				isSuccess = false;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("OrderDetailService -> insertOrderDetail() : " + e.getMessage());
			isSuccess = false;
		}return isSuccess;
	}
	
	public OrderDetail getOrderDetailFromCake(int orderId, int cakeId,int pound) {
		OrderDetail detail = new OrderDetail();
		//Query หา detail orderId, cakeId, pound
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="SELECT * FROM orderdetails WHERE orderId = ? and cakeId =? and pound = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, orderId);
			statement.setInt(2, cakeId);
			statement.setInt(3, pound);
			ResultSet rs = statement.executeQuery();
			if(rs.next())
			{
				//ดึงข้อมูล
				detail.setId(rs.getInt("id"));
				detail.setOrderId(rs.getInt("orderId"));
				detail.setCake(new CakeService().getCake(rs.getInt("cakeId")));
				detail.setPound(rs.getInt("pound"));
				detail.setQuantity(rs.getInt("quantity"));				
			}
			else
			{
				//ดึงข้อมูล
				detail.setOrderId(orderId);
				detail.setCake(new CakeService().getCake(cakeId));
				detail.setPound(pound);
				detail.setQuantity(0);				
			}
			rs.close();
			statement.close();
			conn.close();
			
		} catch (Exception e) {
			detail = null;
			System.out.println("OrderDetailService -> getOrderDetailFromCake()"+ e.getMessage());
		}		
		return detail;
	}
	public  ArrayList <OrderDetail> getOrderDetailFromCakeId() {
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql ="SELECT * FROM orderdetails ";
			Statement statement =conn.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			while(rs.next()) {
				//process
				OrderDetail orders =new OrderDetail();
				orders.setId(rs.getInt("id"));
				orders.setOrderId(rs.getInt("orderId"));
				orders.setCake(new CakeService().getCake(rs.getInt("cakeId")));
				orders.setPound(rs.getInt("pound"));
				orders.setQuantity(rs.getInt("quantity"));	
				lstOrderDetails.add(orders);
			} 
			rs.close();
			statement.close();
			conn.close();
			
		} catch (Exception e) {
			lstOrderDetails = null;
			System.out.println("OrderDetailService -> getOrderDetailFromCakeID()"+ e.getMessage());
		}		
		
		return lstOrderDetails;
	}
}
