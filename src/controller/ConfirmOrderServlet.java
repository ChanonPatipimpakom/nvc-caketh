package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.CakeService;
import data.DepartmentService;
import data.TeacherService;
import data.TeamService;
import model.Cake;
import model.Order;
import model.OrderDetail;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/ConfirmOrder")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOrderServlet() {
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
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		String strReceiveDate =request.getParameter("receiveDate");
		String strReciveTime = request.getParameter("reciveTime");
		String strReciveName = request.getParameter("reciveName");
		String strReciveTel = request.getParameter("reciveTel");
		String strClass = request.getParameter("class_num");
		String strRoom = request.getParameter("room_num");
		int depart_id = Integer.parseInt(request.getParameter("depart_id"));
		int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
		float deposit_money = Float.parseFloat(request.getParameter("deposit_money"));
		String deposit_name = request.getParameter("deposit_name");
		
		Date receiveDate;
		Order order = new Order();
		order.setCustomerId(customerId);
		order.setTeamId(teamId);
		order.setReciveTime(strReciveTime);
		order.setReciveName(strReciveName);
		order.setReciveTel(strReciveTel);
		order.setClass_num(strClass);
		order.setRoom_num(strRoom);
		order.setDepart_id(depart_id);
		order.setTeacherid(teacher_id);
		order.setDeposit_money(deposit_money);
		order.setDeposit_name(deposit_name);
		try {
			receiveDate = new SimpleDateFormat("yyyy-MM-dd").parse(strReceiveDate);	
			
			order.setReceiveDate(receiveDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<OrderDetail> details = new ArrayList<OrderDetail>();
		
		for(Cake cake: new CakeService().getLstCakes()) {
			//Cake type
			for(int p=1;p<=5;p++)
			{
				String strQty = request.getParameter("qty-"+cake.getId() + "-" + p);
						int qty = strQty!=""?Integer.parseInt(strQty):0;
						OrderDetail d = new OrderDetail();
						d.setCake(cake);
						d.setPound(p);
						d.setQuantity(qty);
						details.add(d);
			}			
		}
		order.setTeam(new TeamService().getTeam(teamId));
		order.setDepart(new DepartmentService().getDepart(depart_id));
		order.setTeach(new TeacherService().getTeach(teacher_id));
		order.setDetails(details);
		
		HttpSession session = request.getSession();
		session.setAttribute("order", order);
		request.setAttribute("order", order);
		request.getRequestDispatcher("confirmOrder.jsp").forward(request, response);
	}

}
