package com.practice.Demo.JPA.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.Demo.JPA.Entity.UserEntity;
import com.practice.Demo.JPA.Repository.UserRepository;

@Service
public class JpaService {
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity createResource(UserEntity user) {
		return userRepository.save(user);
		
	}
	
	public List<UserEntity> getResource(){
		return userRepository.findAll();
	}

}
