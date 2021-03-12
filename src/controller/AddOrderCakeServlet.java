package controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.OrderService;
import model.Order;

/**
 * Servlet implementation class AddOrderCakeServlet
 */
@WebServlet("/AddOrderCake")
public class AddOrderCakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderCakeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("text/html; charset=UTF-8");
		
		
		OrderService service = new OrderService();
		
		//int orderId = Integer.parseInt(request.getParameter("orderId"));
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		String strReceiveDate =request.getParameter("receiveDate");
		
		Date receiveDate;
		Order order = new Order();
		try {
			receiveDate = new SimpleDateFormat("yyyy-MM-dd").parse(strReceiveDate);
			
			order.setCustomerId(customerId);
			order.setTeamId(teamId);
			order.setReceiveDate(receiveDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(service.insertOrder(order)) {
			//success
			response.sendRedirect("index.jsp");
		}
		
		
		
		
		
		
		//request.setAttribute("orders", orders);
	}	

}
