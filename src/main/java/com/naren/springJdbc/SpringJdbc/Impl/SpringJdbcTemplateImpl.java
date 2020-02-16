package com.naren.springJdbc.SpringJdbc.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.naren.springJdbc.SpringJdbc.SpringJdbcDao;
import com.naren.springJdbc.SpringJdbc.Entity.Employee;

public class SpringJdbcTemplateImpl implements SpringJdbcDao {

	
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	@Override
	public void save(Employee e) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource);
		String Query="insert into employee(id,ename,esal) values(?,?,?)";
		Object[] obj=new Object[] {e.getId(),e.getEname(),e.getEsal()};
		int executeUpdate =jdbcTemplate.update(Query, obj);
		
		if(executeUpdate !=0) {
			System.out.println("Employee Entry inserted successfully" + e.getId());
		}else {
			System.out.println("Employee Entry not inserted successfully" + e.getId());
		}
		
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource);
		String Query="select * from employee where id=?";
		
		Employee queryForObject = jdbcTemplate.queryForObject(Query, new Object[] {id}, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs,int rowNum) throws SQLException {
				Employee e= new Employee();
				e.setId(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setEsal(rs.getString(3));
				return e;
				
			}
		});
		
		return queryForObject;
		
		
		
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource);
		String Query="select * from employee";
		
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(Query);
		List<Employee> list= new ArrayList<Employee>();
		for(Map<String,Object> m:queryForList) {
			Employee e= new Employee();
			e.setId(Integer.parseInt(String.valueOf(m.get("id"))));
			e.setEname(String.valueOf(m.get("ename")));
			e.setEsal(String.valueOf(m.get("esal")));
			list.add(e);
			
		}
		return list;
		
		
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource);
		String Query="delete from employee where id=?";
		
		int executeUpdate =jdbcTemplate.update(Query,id);
		
		if(executeUpdate !=0) {
			System.out.println("Employee Entry deleted successfully" + id);
		}else {
			System.out.println("Employee Entry not deleted successfully" + id);
		}
		
	}

	@Override
	public void update(Employee e) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource);
		String Query="update employee set esal=? where id=?";
		Object[] obj=new Object[] {e.getEsal(),e.getId()};
		int executeUpdate =jdbcTemplate.update(Query, obj);
		
		if(executeUpdate !=0) {
			System.out.println("Employee Entry updated successfully" + e.getId());
		}else {
			System.out.println("Employee Entry not updated successfully" + e.getId());
		}
		
	}

}
