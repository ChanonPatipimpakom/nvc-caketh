package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.CakeService;
import model.Cake;


/**
 * Servlet implementation class AddCakeServlet
 */
@WebServlet("/AddCake")
public class AddCakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCakeServlet() {
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
		String name = request.getParameter("name");
		Float pricePerPound =Float.parseFloat(request.getParameter("pricePerPound"));
		Float discountRate =Float.parseFloat(request.getParameter("discountRate")); 
		
		Cake cake = new Cake();
		cake.setName(name);
		cake.setPricePerPound(pricePerPound);
		cake.setDiscountRate(discountRate);
		if(new CakeService().insertCake(cake))
		{
			
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Complete');");
			   out.println("location='ShowCake';");
			   out.println("</script>");
		}
		else {
			response.sendRedirect("ShowCake");
		}
	}
	}


