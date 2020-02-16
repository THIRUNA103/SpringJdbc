package com.naren.springJdbc.SpringJdbc.Entity;

public class Employee {
	
	private int id;
	private String ename;
	private String esal;
	public String getEsal() {
		return esal;
	}
	public void setEsal(String esal) {
		this.esal = esal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", esal=" + esal + "]";
	}

}
