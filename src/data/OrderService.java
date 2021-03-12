package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Department;
import model.Order;
import model.OrderDetail;
import model.Team;
import utility.DBConnection;
import utility.DatesConversion;

public class OrderService {
	private ArrayList<Order> allOrders = new ArrayList<Order>();

	public OrderService() {
	}

	public Order getOrder(int orderId) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql = "SELECT *,orderstatus.name as statusName,department.department as depart,teacher.name as teacherName FROM orders,orderstatus,department,teacher WHERE orderId=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, orderId);
			ResultSet rs = statement.executeQuery();
			Order order = new Order();
			Team team = new Team();
			Department depart = new Department();
			while (rs.next()) {
				order.setOrderId(rs.getInt("orderId"));
				order.setCustomerId(rs.getInt("customerId"));
				order.setTeamId(rs.getInt("teamId"));
				order.setStatusName(rs.getString("statusName"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setReceiveDate(rs.getDate("receiveDate"));
				order.setReciveTime(rs.getString("reciveTime"));
				order.setReciveName(rs.getString("reciveName"));
				order.setReciveTel(rs.getString("reciveTel"));
				order.setClass_num(rs.getString("class"));
				order.setRoom_num(rs.getString("room"));
				order.setDepart_id(rs.getInt("depart_id"));
				order.setTeacherid(rs.getInt("teacher_id"));
				order.setDeposit_money(rs.getFloat("deposit_money"));
				order.setDeposit_name(rs.getString("deposit_name"));
				order.setTeam(new TeamService().getTeam(rs.getInt("teamId")));
				order.setDepart(new DepartmentService().getDepart(rs.getInt("depart_id")));
				order.setTeach(new TeacherService().getTeach(rs.getInt("teacher_id")));
				OrderDetailService service = new OrderDetailService();
				ArrayList<OrderDetail> details = service.getOrderDetailsFromOrderId(rs.getInt("orderId"));
				order.setDetails(details);
			}
			rs.close();
			statement.close();
			conn.close();
			return order;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("OrderService->getLstOrder():" + e.getMessage());
			return null;
		}
	}

	public ArrayList<Order> getAllOrder() {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql = "SELECT *,orderstatus.name as statusName,team.name as teamName FROM orders,orderstatus,team WHERE orders.status=orderstatus.id AND orders.teamId=team.id";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Order o = new Order();
				o.setOrderId(rs.getInt("orderId"));
				o.setCustomerId(rs.getInt("customerId"));
				o.setTeamName(rs.getString("teamName"));
				o.setStatusName(rs.getString("statusName"));
				o.setOrderDate(rs.getDate("orderDate"));
				o.setReceiveDate(rs.getDate("receiveDate"));
				OrderDetailService service = new OrderDetailService();
				ArrayList<OrderDetail> details = service.getOrderDetailsFromOrderId(rs.getInt("orderId"));
				o.setDetails(details);
				allOrders.add(o);

			}
			rs.close();
			statement.close();
			conn.close();

		} catch (Exception e) {
			allOrders = null;
			System.out.println("OrderService -> getAllCake()" + e.getMessage());
			// TODO: handle exception
		}
		return allOrders;

	}
	
	public boolean insertOrder(Order order) {
		boolean isSuccess = false;
		try {
			DBConnection dbConnection = new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql = "INSERT INTO orders (customerId, teamId, orderDate, receiveDate, status, reciveTime, reciveName, reciveTel, class, room, depart_id, teacher_id, deposit_money, deposit_name)VALUES(?,?,now(),?,2,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, order.getCustomerId());
			statement.setInt(2, order.getTeamId());
			statement.setDate(3, (DatesConversion.convertUtilToSql(order.getReceiveDate())));
			statement.setString(4, order.getReciveTime());
			statement.setString(5, order.getReciveName());
			statement.setString(6, order.getReciveTel());
			statement.setString(7, order.getClass_num());
			statement.setString(8, order.getRoom_num());
			statement.setInt(9, order.getDepart_id());
			statement.setInt(10, order.getTeacherid());
			statement.setFloat(11, order.getDeposit_money());
			statement.setString(12, order.getDeposit_name());
			int effectedRow = statement.executeUpdate();

			if (effectedRow != 0) {
				// Insert details
				ResultSet rs = statement.getGeneratedKeys();
				rs.next();
				int orderId = rs.getInt(1);
				for (OrderDetail detail : order.getDetails()) {
					detail.setOrderId(orderId);
					OrderDetailService service = new OrderDetailService();
					if (detail.getQuantity() > 0) {
						if (service.insertOrdersDetail(detail)) {
							isSuccess = true;
						} else {
							isSuccess = false;
							throw new Exception();
						}
					}
				}
			} else
				isSuccess = false;

		} catch (Exception e) {
			System.out.println("OrderCakeService -> insertOrder() : " + e.getMessage());
			isSuccess = false;

		}
		return isSuccess;

	}

	public ArrayList<Order> getOrdersFromCustomerId(int customerId) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql = "SELECT *,orderstatus.name as statusName,team.name as teamName FROM orders,orderstatus,team WHERE orders.status=orderstatus.id AND orders.teamId=team.id AND customerId=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, customerId);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Order o = new Order();
				o.setOrderId(rs.getInt("orderId"));
				o.setCustomerId(rs.getInt("customerId"));
				o.setTeamName(rs.getString("teamName"));
				o.setStatusName(rs.getString("statusName"));
				o.setOrderDate(rs.getDate("orderDate"));
				o.setReceiveDate(rs.getDate("receiveDate"));
				OrderDetailService service = new OrderDetailService();
				ArrayList<OrderDetail> details = service.getOrderDetailsFromOrderId(rs.getInt("orderId"));
				o.setDetails(details);
				allOrders.add(o);

			}
			rs.close();
			statement.close();
			conn.close();

		} catch (Exception e) {
			allOrders = null;
			System.out.println("OrderService -> getOrdersFromCustomerId()" + e.getMessage());
			// TODO: handle exception
		}
		return allOrders;

	}

	public ArrayList<Order> getOrdersFromTeamId(int teamId) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql = "SELECT * FROM orders WHERE teamId=? AND orders.status=1";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, teamId);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Order o = new Order();
				o.setOrderId(rs.getInt("orderId"));
				o.setCustomerId(rs.getInt("customerId"));
				o.setTeamId(rs.getInt("teamId"));
				o.setOrderDate(rs.getDate("orderDate"));
				o.setReceiveDate(rs.getDate("receiveDate"));
				OrderDetailService service = new OrderDetailService();
				ArrayList<OrderDetail> details = service.getOrderDetailsFromOrderId(rs.getInt("orderId"));
				o.setDetails(details);
				allOrders.add(o);

			}
			rs.close();
			statement.close();
			conn.close();

		} catch (Exception e) {
			allOrders = null;
			System.out.println("OrderService -> getOrdersFromTeamId()" + e.getMessage());
			// TODO: handle exception
		}
		return allOrders;
	}
	
	public ArrayList<Order> getOrdersFromDepartId(int depart_id) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql = "SELECT * FROM orders WHERE depart_id=? AND orders.status=1";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, depart_id);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Order o = new Order();
				o.setOrderId(rs.getInt("orderId"));
				o.setCustomerId(rs.getInt("customerId"));
				o.setDepart_id(rs.getInt("depart_id"));
				o.setOrderDate(rs.getDate("orderDate"));
				o.setReceiveDate(rs.getDate("receiveDate"));
				OrderDetailService service = new OrderDetailService();
				ArrayList<OrderDetail> details = service.getOrderDetailsFromOrderId(rs.getInt("orderId"));
				o.setDetails(details);
				allOrders.add(o);

			}
			rs.close();
			statement.close();
			conn.close();

		} catch (Exception e) {
			allOrders = null;
			System.out.println("OrderService -> getOrdersFromTeamId()" + e.getMessage());
			// TODO: handle exception
		}
		return allOrders;
	}
	
	public ArrayList<Order> getOrdersFromTeacherId(int teacher_id) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql = "SELECT * FROM orders WHERE teacher_id=? AND orders.status=1";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, teacher_id);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Order o = new Order();
				o.setOrderId(rs.getInt("orderId"));
				o.setCustomerId(rs.getInt("customerId"));
				o.setTeacherid(rs.getInt("teacher_id"));
				o.setOrderDate(rs.getDate("orderDate"));
				o.setReceiveDate(rs.getDate("receiveDate"));
				OrderDetailService service = new OrderDetailService();
				ArrayList<OrderDetail> details = service.getOrderDetailsFromOrderId(rs.getInt("orderId"));
				o.setDetails(details);
				allOrders.add(o);

			}
			rs.close();
			statement.close();
			conn.close();

		} catch (Exception e) {
			allOrders = null;
			System.out.println("OrderService -> getOrdersFromTeacherId()" + e.getMessage());
			// TODO: handle exception
		}
		return allOrders;
	}

	public Order getOrdersFromOrderId(int orderId) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection conn = dbConnection.getConnection();
			String sql = "SELECT *,orderstatus.name as statusName,team.name as teamName FROM orders,orderstatus,team WHERE orders.status=orderstatus.id AND orders.teamId=team.id AND orderId=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			Order order = new Order();
			statement.setInt(1, orderId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				order.setOrderId(rs.getInt("orderId"));
				order.setCustomerId(rs.getInt("customerId"));
				order.setTeamName(rs.getString("teamName"));
				order.setStatusName(rs.getString("statusName"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setReceiveDate(rs.getDate("receiveDate"));
				OrderDetailService service = new OrderDetailService();
				ArrayList<OrderDetail> details = service.getOrderDetailsFromOrderId(rs.getInt("orderId"));
				order.setDetails(details);
			}else {
				order=null;
			}
			rs.close();
			statement.close();
			conn.close();
			return order;
		} catch (Exception e) {
			System.out.println("OrderService -> getOrdersFromCustomerId()" + e.getMessage());
			return null;
		}
	}
	public boolean updateOrderStatus (int orderId) {
		boolean isSuccess =false;
		try {
			DBConnection dbConnection =new DBConnection();
			Connection conn =dbConnection.getConnection();
			String sql ="UPDATE orders SET status=1 WHERE orderId=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, orderId);
			int effectedRow = statement.executeUpdate();
			if(effectedRow!=0)
				isSuccess =true;
			else {
				isSuccess =false;
			}
		}catch (Exception e) { 
			System.out.println("OrderService-> updateOrderStatus():"+e.getMessage());
			isSuccess =false;
		}
		return isSuccess;
	}
}
