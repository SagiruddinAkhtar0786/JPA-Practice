package com.practice.Demo.JPA.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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

}
