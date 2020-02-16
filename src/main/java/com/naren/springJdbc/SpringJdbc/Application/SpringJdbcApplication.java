package com.naren.springJdbc.SpringJdbc.Application;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.naren.springJdbc.SpringJdbc.SpringJdbcDao;
import com.naren.springJdbc.SpringJdbc.Entity.Employee;
import com.naren.springJdbc.SpringJdbc.Impl.SpringJdbcDaoImpl;

public class SpringJdbcApplication {
	
	public static void main(String[] args) {
		
		
ClassPathXmlApplicationContext cxt= new ClassPathXmlApplicationContext("spring.xml");

		SpringJdbcDao dao= cxt.getBean("SpringJdbcDao", SpringJdbcDao.class);
		Employee e= new Employee();
//		for(int i=20;i<=30;i++) {
//			e.setId(i);
//			e.setEname("Nani"+String.valueOf(i));
//		e.setEsal(String.valueOf(i*1000));
//			dao.save(e);
//		}
		
//		List<Employee> all = dao.getAll();
//		for(Employee d:all) {
//			System.out.println(d);
//		}
		
//		
//		Employee byId = dao.getById(21);
//		System.out.println(byId);
		
		e.setId(21);
		e.setEsal("90000");
		
		dao.update(e);
//		
//
		Employee byId = dao.getById(21);
		System.out.println(byId);
		
//		
//		dao.Delete(4);
//		
//
//		Employee byId = dao.getById(4);
//		System.out.println(byId);
		
		
		
	}

}
