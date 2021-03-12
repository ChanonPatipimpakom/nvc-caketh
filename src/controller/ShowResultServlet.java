package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.OrderService;
import model.Order;

/**
 * Servlet implementation class ShowResultServlet
 */
@WebServlet("/ShowResult")
public class ShowResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			OrderService service = new OrderService();
			Order order = service.getOrdersFromOrderId(orderId);
			
			if(order==null)
			{
				String msg = "สำเร็จ";
				request.setAttribute("msg",msg);
				request.getRequestDispatcher("searchorderid.jsp").forward(request, response);
				
			}else {
				request.setAttribute("resultorder", order);
				request.getRequestDispatcher("content/resultsearch.jsp").forward(request, response);
			}
			
			
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
