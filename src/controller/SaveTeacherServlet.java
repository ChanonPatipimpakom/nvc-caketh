package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.TeacherService;
import model.Teacher;

/**
 * Servlet implementation class SaveTeacherServlet
 */
@WebServlet("/SaveTeacher")
public class SaveTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveTeacherServlet() {
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
		 
		Teacher teach = new Teacher();
		teach.setId(id);
		teach.setName(name);
		
		 if(new TeacherService().updateTeach(teach)) {
			 out.println("<script type=\"text/javascript\">");
			 out.println("alert('บันทึกข้อมูลสำเร็จ');");
			 out.println("location='ShowTeacher';");
			 out.println("</script>");
			 
		 }
		 else {
			 response.sendRedirect("EditTeacher?id="+ teach.getId());
		 }
	}

}
