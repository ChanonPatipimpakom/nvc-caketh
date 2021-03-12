package model;

import java.util.ArrayList;

public class Teacher {
	private int id;
	private String name;
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	public Teacher() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Order> getOrdersFromTeacherId(){
		return orders;
		}
	public void setOrders(ArrayList<Order>orders) {
	this.orders = orders;
		
	}public ArrayList<Order> getOrders() {
		return orders;
	}
}
