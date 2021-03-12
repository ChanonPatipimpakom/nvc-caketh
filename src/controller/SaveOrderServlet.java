package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.OrderService;
import model.Order;

/**
 * Servlet implementation class SaveOrderServlet
 */
@WebServlet("/SaveOrder")
public class SaveOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveOrderServlet() {
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
		HttpSession session = request.getSession();
		Order order = (Order)session.getAttribute("order");
		OrderService service =new OrderService();
		PrintWriter out = response.getWriter();
		
		if(service.insertOrder(order)) {
			//Insert Success
			
		
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('ok Save');");
			   out.println("location='orderCake.jsp';");
			   out.println("</script>");
			
		}
		else {
			response.sendRedirect("orderCake.jsp");
		}
		
	}

}
