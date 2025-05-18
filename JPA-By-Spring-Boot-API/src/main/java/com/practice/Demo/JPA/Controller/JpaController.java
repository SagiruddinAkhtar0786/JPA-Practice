package com.practice.Demo.JPA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Demo.JPA.Entity.UserEntity;
import com.practice.Demo.JPA.Service.JpaService;
/*
@Controller
public class JpaController {
	
	@Autowired
	private JpaService service;
	
	@PostMapping("createDetails")
	@ResponseBody
	public UserEntity createResource(@RequestBody UserEntity user){
		return service.createResource(user);
	}
	
	@GetMapping("GetDetails")
	@ResponseBody
	public List<UserEntity> getResource(){
		return service.getResource();
	}

}*/


@RestController
public class JpaController {
	
	@Autowired
	private JpaService service;
	
	@PostMapping("createDetails")
	//@ResponseBody
	public UserEntity createResource(@RequestBody UserEntity user){
		return service.createResource(user);
	}
	
	@GetMapping("GetDetails")
	//@ResponseBody
	public List<UserEntity> getResource(){
		return service.getResource();
	}
	
	@DeleteMapping("deleteDetails/{id}")
	public String deleteRecord(@PathVariable int id) {
		service.deleteRecord(id);
		return "user with ID " +id +" deleted Successfully";
	}
	
	@PutMapping("updateDetails/{id}")
	public UserEntity updateDetails(@PathVariable int id,@RequestBody UserEntity user) {
		return service.updateDetails(id,user);
	}

}
