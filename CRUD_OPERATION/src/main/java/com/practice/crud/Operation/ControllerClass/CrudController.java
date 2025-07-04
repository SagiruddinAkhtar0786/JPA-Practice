package com.practice.crud.Operation.ControllerClass;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class CrudController {

	
	public ResponseEntity<String> fetchData(){
		return new ResponseEntity<>("data fetiching ",HttpStatus.OK);
	}
}
