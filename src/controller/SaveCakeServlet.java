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
 * Servlet implementation class SaveCakeServlet
 */
@WebServlet("/SaveCake")
public class SaveCakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCakeServlet() {
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
		String name =request.getParameter("name");
		Float pricePerPound =Float.parseFloat(request.getParameter("pricePerPound"));
		Float discountRate =Float.parseFloat(request.getParameter("discountRate")); 
		
		Cake cake = new Cake();
		cake.setId(id);
		cake.setName(name);
		cake.setPricePerPound(pricePerPound);
		cake.setDiscountRate(discountRate);
		
		 if(new CakeService().updateCake(cake)) {
			 out.println("<script type=\"text/javascript\">");
			 out.println("alert('แก้ไขข้อมูลเสร็จสิ้น');");
			 out.println("location='ShowCake';");
			 out.println("</script>");
		 }
		 else {
			 response.sendRedirect("EditCake?id="+ cake.getId());
		 }
	}
	}

