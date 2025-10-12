package com.practice.Fetch_data.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long internalInd;
	private int userId;
	private int id;
	private String title;
	private String body;
	private int serialNumber;
	
	
}
