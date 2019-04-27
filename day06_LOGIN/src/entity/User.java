package entity;

import java.util.Date;

public class User {
	private int ID;
	private String name;
	private String password;
	private String email;
	private Date birthday;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	@Override
	public String toString() {
		return "User [ID=" + ID + ", name=" + name + ", password=" + password + ", email=" + email + ", birthday="
				+ birthday + "]";
	}
	

}
