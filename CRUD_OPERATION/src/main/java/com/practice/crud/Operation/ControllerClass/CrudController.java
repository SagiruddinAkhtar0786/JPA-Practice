package com.practice.crud.Operation.ControllerClass;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.crud.Operation.Dao.EmployeeDao;
import com.practice.crud.Operation.Entity.Employee;

@RestController
@RequestMapping("/crud")
public class CrudController {

	@Autowired
	EmployeeDao employeeDAO;
	
	@GetMapping
	public ResponseEntity<List<Employee>> fetchData() throws SQLException{
		System.out.println("hit");
		 List<Employee> emp = employeeDAO.getEmployee();
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Employee> createData(@RequestBody Employee emp) throws SQLException{
		
	//	emp.setId(0);
		System.out.println("hitting");
		
		Employee emp = employeeDAO.saveEmployee(emp);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int id){
		
		System.out.println("id >> "+id);
		Employee emp = employeeDAO.getEmployeeById(id);
		
		if(emp != null) {
			
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("resource with given id Not Found ",HttpStatus.NOT_FOUND);

		}
		
	}
	
}
