package com.naren.springJdbc.SpringJdbc;

import java.util.List;

import com.naren.springJdbc.SpringJdbc.Entity.Employee;

public interface SpringJdbcDao {
	
	public void save(Employee e);
	public Employee getById(int id);
	public List<Employee> getAll();
	public void Delete(int id);
	public void update(Employee e);
	

}
