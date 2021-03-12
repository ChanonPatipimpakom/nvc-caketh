package model;

public class Customer {
 private int id;
 private String username;
 private String password;
 private String status;
 private String name;
 private String address;
 private String email;
 private String tel;

 public Customer() {}

public Customer(int id, String username, String password, String status, String name, String address, String email,
		String tel) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.status = status;
	this.name = name;
	this.address = address;
	this.email = email;
	this.tel = tel;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}
 
 
 
 
}
