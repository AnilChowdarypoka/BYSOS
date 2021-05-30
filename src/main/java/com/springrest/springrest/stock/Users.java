package com.springrest.springrest.stock;

public class Users {
	private String Name ;
	private long Mobile;
	private String userid;
public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

@Override
public String toString() {
	return "Users [Name=" + Name + ", Mobile=" + Mobile + ", userid=" + userid + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
public Users(String name, long mobile, String userid) {
	super();
	Name = name;
	Mobile = mobile;
	this.userid = userid;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public long getMobile() {
	return Mobile;
}
public void setMobile(long mobile) {
	Mobile = mobile;
}
public String getuserid() {
	return userid;
}
public void setuserid(String userid) {
	this.userid = userid;
}

}
