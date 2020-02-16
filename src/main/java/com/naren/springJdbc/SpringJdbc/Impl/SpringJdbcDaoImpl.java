package com.naren.springJdbc.SpringJdbc.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.naren.springJdbc.SpringJdbc.SpringJdbcDao;
import com.naren.springJdbc.SpringJdbc.Entity.Employee;

public class SpringJdbcDaoImpl implements SpringJdbcDao{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	public void save(Employee e) {
		
		String Query="insert into  employee (id,ename,esal) values(?,?,?)";
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=this.dataSource.getConnection();
			ps=con.prepareStatement(Query);
			ps.setInt(1,e.getId());
			ps.setString(2, e.getEname());
			ps.setString(3, e.getEsal());
			
			int executeUpdate = ps.executeUpdate();
			
			if(executeUpdate !=0) {
				System.out.println("Employee Entry inserted successfully" + e.getId());
			}else {
				System.out.println("Employee Entry not inserted successfully" + e.getId());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		
		
	}

	public Employee getById(int id) {
		
		String Query="Select * from employee where id=?";
		
		Connection con=null;
		PreparedStatement ps=null;
		Employee e=null;
		
		try {
			con=this.dataSource.getConnection();
			ps=con.prepareStatement(Query);
			ps.setInt(1,id);
			
			ResultSet executeQuery = ps.executeQuery();
			
			while(executeQuery.next()) {
				e= new Employee();
				e.setId(executeQuery.getInt(1));
				e.setEname(executeQuery.getString(2));
				e.setEsal(executeQuery.getString(3));
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		return e;
		
	}

	public List<Employee> getAll() {
		
		String Query="Select * from employee";
		
		Connection con=null;
		PreparedStatement ps=null;
		List<Employee> list= new ArrayList<Employee>();
		
		
		try {
			con=this.dataSource.getConnection();
			ps=con.prepareStatement(Query);
			
			
			ResultSet executeQuery = ps.executeQuery();
			
			while(executeQuery.next()) {
				Employee e= new Employee();
				e.setId(executeQuery.getInt(1));
				e.setEname(executeQuery.getString(2));
				e.setEsal(executeQuery.getString(3));
				list.add(e);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		return list;
		
	}

	public void Delete(int id) {
		
		String Query="Delete from employee where id=?";
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=this.dataSource.getConnection();
			ps=con.prepareStatement(Query);
			ps.setInt(1,id);
			
			int executeUpdate = ps.executeUpdate();
			
			if(executeUpdate !=0) {
				System.out.println("Employee Entry deleted successfully" + id);
			}else {
				System.out.println("Employee Entry not deleted successfully" + id);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		
		
	}

	public void update(Employee e) {
		
		String Query="update employee set esal=? where id=?";
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=this.dataSource.getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, e.getEsal());
			ps.setInt(2,e.getId());
			
			int executeUpdate = ps.executeUpdate();
			
			if(executeUpdate !=0) {
				System.out.println("Employee Entry updated successfully" + e.getId());
			}else {
				System.out.println("Employee Entry not updated successfully" + e.getId());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		
		
	}

}
