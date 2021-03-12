package model;

public class OrderDetail {
private int id;
private int orderId;
private Cake cake;
private int pound;
private int quantity;
private int totalPound;

public OrderDetail() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

 public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public Cake getCake() {
	return cake;
}
public void setCake(Cake cake) {
	this.cake = cake;
}
public int getPound() {
	return pound;
}
public void setPound(int pound) {
	this.pound = pound;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getTotalPound() {
	return  this.pound * this.quantity;
}

}
