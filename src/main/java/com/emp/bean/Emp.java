package com.emp.bean;

public class Emp {

	private int id;
	private String name;
	private String city;
	private String mobile;
	private int sal;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Emp(int id, String name, String city, String mobile, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.mobile = mobile;
		this.sal = sal;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", city=" + city + ", mobile=" + mobile + ", sal=" + sal + "]";
	}
	
	
}
