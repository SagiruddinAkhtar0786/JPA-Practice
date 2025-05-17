package com.practice.Demo.JPA.Service;

import java.util.List;
import java.util.Optional;

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

	

	public void deleteRecord(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	public UserEntity updateDetails(int id, UserEntity updatedUser) {
		// TODO Auto-generated method stub
	//	UserEntity existingUser = userRepository.findById(id)
		//		.orElseThrow(() -> new RunTimeException("User not found with id :"+id));
		Optional<UserEntity> existingUserOpt = userRepository.findById(id);
		
		if(existingUserOpt.isPresent())
		{
			UserEntity existingUser = existingUserOpt.get();
			existingUser.setName(updatedUser.getName());
			existingUser.setEmail(updatedUser.getEmail());
	        return userRepository.save(existingUser); // Save and return updated entity

		}else {
	        throw new RuntimeException("User not found with id: " + id);

		}
		//return null;
	}

}
