package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.OrderDetailService;
import data.OrderService;
import model.Customer;
import model.Order;
import model.OrderDetail;

/**
 * Servlet implementation class ShowOrderCompleteServlet
 */
@WebServlet("/ShowOrderComplete")
public class ShowOrderCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrderCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");		
		ArrayList<Order> orders = new ArrayList<Order>();
		OrderService service = new OrderService();
		orders = service.getOrdersFromCustomerId(customer.getId());
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/index.jsp?menu=orderComplete").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	

}
