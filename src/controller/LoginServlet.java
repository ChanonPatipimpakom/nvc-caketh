package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.LoginService;
import data.OrderService;
import model.Customer;
import model.Order;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		HttpSession session = request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginService service = new LoginService();
		
		Customer customer = service.login(username, password);
		
		if(customer!=null) {
			if(customer.getStatus().equals("admin"))
			{
			session.setAttribute("customer",customer);
			response.sendRedirect("index.jsp");
			}
			else if (customer.getStatus().equals("user")) {
				session.setAttribute("customer",customer);
				response.sendRedirect("orderCake.jsp");
			}
		}
	else 
	{
		String errorMessage = "Username Or Password Is Wrong";
		session.setAttribute("errorMessage",errorMessage);
		response.sendRedirect("login.jsp");
	}
	}
}
