package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.CustomerService;
import model.Customer;

/**
 * Servlet implementation class SaveUserServlet
 */
@WebServlet("/SaveUser")
public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUserServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int id= Integer.parseInt(request.getParameter("id"));
		String username =request.getParameter("username");
		String name=request.getParameter("name");
		String address =request.getParameter("address");
		String email =request.getParameter("email");
		String tel =request.getParameter("tel");
		String status =request.getParameter("status");
		
		
	
		
		Customer customer = new Customer();
		customer.setId(id);
		customer.setUsername(username);
		customer.setName(name);
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setTel(tel);
		customer.setStatus(status);
	
		
		 if(new CustomerService().updateCustomer(customer)) {
			 out.println("<script type=\"text/javascript\">");
			 out.println("alert('แก้ไขสำเร็จ');");
			 HttpSession session = request.getSession();
			 session.setAttribute("customer",customer);
			 out.println("location='EditUser';");
			 out.println("</script>");
		 }
		 else {
			 response.sendRedirect("EditUser?id="+ customer.getId());
		 }
	}

}
