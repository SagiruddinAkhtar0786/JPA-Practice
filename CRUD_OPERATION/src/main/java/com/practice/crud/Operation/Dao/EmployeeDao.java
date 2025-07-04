package com.practice.crud.Operation.Dao;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.crud.Operation.Entity.Employee;

@Repository
public class EmployeeDao {
	
	
	@Autowired
	private DataSource dataSource;
	
	Connection con =null;
	PreparedStatement st = null;
	
	
	public List<Employee> getEmployee() throws SQLException {
		// TODO Auto-generated method stub
		
		List<Employee> employees = new ArrayList<>();
		String sql = "select * from Employee";
		
		try {
			con = dataSource.getConnection();
			st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setEmail(rs.getString("email"));
                employees.add(emp);
			}
					
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			if(con != null)
				con.close();
			if(st != null)
				st.close();
		}
		return employees;
	}
	
	public void saveEmployee(Employee emp) throws SQLException {
		
		String sqlQ = "INSERT INTO Employee(id,name,email) VALUES(?,?,?)";
		try {
			con = dataSource.getConnection();
			 st = con.prepareStatement(sqlQ);
			 
			 st.setInt(1, emp.getId());
			 st.setString(2,emp.getName());
			 st.setString(3, emp.getEmail());
			 st.executeUpdate();
			 System.out.println("emp.getId() >> "+emp.getId()+" emp.getName() >>  "+emp.getName());
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			if(con != null)
				con.close();
			if(st != null)				
				st.close();
			
			 System.out.println("emp.getId() >> "+emp.getId()+" emp.getName() >>  "+emp.getName());

		}
		
		//emp.setName(null);
	}

	
	
	public Employee getEmployeeById() {
		// TODO Auto-generated method stub
		return null;
	}
}
