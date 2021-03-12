package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DepartmentService;
import data.TeamService;
import model.Department;
import model.Team;

/**
 * Servlet implementation class SaveDepartmentServlet
 */
@WebServlet("/SaveDepartment")
public class SaveDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveDepartmentServlet() {
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
		 
		Department depart = new Department();
		depart.setId(id);
		depart.setName(name);
		
		 if(new DepartmentService().updateDepart(depart)) {
			 out.println("<script type=\"text/javascript\">");
			 out.println("alert('บันทึกข้อมูลสำเร็จ');");
			 out.println("location='ShowDepartment';");
			 out.println("</script>");
			 
		 }
		 else {
			 response.sendRedirect("EditDepartment?id="+ depart.getId());
		 }
	}

}
