package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.OrderDetailService;
import data.OrderService;
import model.Order;
import model.OrderDetail;

/**
 * Servlet implementation class ExportFileServlet
 */
@WebServlet("/ExportFile")
public class ExportFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<OrderDetail> orders = new ArrayList <OrderDetail>();
		OrderDetailService service = new OrderDetailService();
		orders = service.getOrderDetailFromCakeId();
		request.setAttribute("ex", orders);
		
		ArrayList<Order> ordersch = new ArrayList<Order>();
		OrderService service2 = new OrderService();
		ordersch = service2.getAllOrder();
		request.setAttribute("ex2", ordersch);
		
		request.getRequestDispatcher("/export.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
