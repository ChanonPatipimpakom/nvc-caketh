package model;

import java.util.ArrayList;

public class Team {
	private int id;
	private String name;
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	public Team() {
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
	public ArrayList<Order> getOrdersFromTeamId(){
		return orders;
		}
	public void setOrders(ArrayList<Order>orders) {
	this.orders = orders;
		
	}public ArrayList<Order> getOrders() {
		return orders;
	}
	
}
