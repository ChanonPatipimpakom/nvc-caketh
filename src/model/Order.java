package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
	private int orderId;
	private int customerId;
	private String teamName;
	private int teamId;
	private String statusName;
	private Date orderDate;
	private Date receiveDate;
	private String reciveTime;
	private String reciveName;
	private String reciveTel;
	private String class_num;
	private String room_num;
	private String deposit_name;
	private float deposit_money;
	private String department;
	private int depart_id;
	private int teacherid;
	private String teachername;
	
	private ArrayList<OrderDetail> details = new ArrayList<OrderDetail>(); 
	private Team team =new Team();
	private Department depart = new Department();
	private Teacher teach = new Teacher();
	
	public Order() {
		super();
	}

	public Order(int orderId, int customerId, String teamName, int teamId, String statusName, Date orderDate,
			Date receiveDate, String reciveTime, String reciveName, String reciveTel, String class_num, String room_num,
			String deposit_name, float deposit_money, String department, int depart_id, int teacherid,
			String teachername, ArrayList<OrderDetail> details, Team team, Department depart, Teacher teach) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.teamName = teamName;
		this.teamId = teamId;
		this.statusName = statusName;
		this.orderDate = orderDate;
		this.receiveDate = receiveDate;
		this.reciveTime = reciveTime;
		this.reciveName = reciveName;
		this.reciveTel = reciveTel;
		this.class_num = class_num;
		this.room_num = room_num;
		this.deposit_name = deposit_name;
		this.deposit_money = deposit_money;
		this.department = department;
		this.depart_id = depart_id;
		this.teacherid = teacherid;
		this.teachername = teachername;
		this.details = details;
		this.team = team;
		this.depart = depart;
		this.teach = teach;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getReciveTime() {
		return reciveTime;
	}

	public void setReciveTime(String reciveTime) {
		this.reciveTime = reciveTime;
	}

	public String getReciveName() {
		return reciveName;
	}

	public void setReciveName(String reciveName) {
		this.reciveName = reciveName;
	}

	public String getReciveTel() {
		return reciveTel;
	}

	public void setReciveTel(String reciveTel) {
		this.reciveTel = reciveTel;
	}

	public String getClass_num() {
		return class_num;
	}

	public void setClass_num(String class_num) {
		this.class_num = class_num;
	}

	public String getRoom_num() {
		return room_num;
	}

	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getDepart_id() {
		return depart_id;
	}

	public void setDepart_id(int depart_id) {
		this.depart_id = depart_id;
	}

	public ArrayList<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(ArrayList<OrderDetail> details) {
		this.details = details;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Department getDepart() {
		return depart;
	}

	public void setDepart(Department depart) {
		this.depart = depart;
	}
	
	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public Teacher getTeach() {
		return teach;
	}

	public void setTeach(Teacher teach) {
		this.teach = teach;
	}

	public String getDeposit_name() {
		return deposit_name;
	}

	public void setDeposit_name(String deposit_name) {
		this.deposit_name = deposit_name;
	}

	public float getDeposit_money() {
		return deposit_money;
	}

	public void setDeposit_money(float deposit_money) {
		this.deposit_money = deposit_money;
	}

	public int getTotalPound() {
		int sumPound=0;
		ArrayList<OrderDetail> details = this.getDetails();
		for(OrderDetail d: details) {
			sumPound+=d.getTotalPound();
		}			
		return sumPound;
	}
	
}


