/**
 * 
 */
package com.practice.Fetch_data.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Fetch_data.PostService.PostService;

/**
 * 
 */
@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	 @GetMapping("/posts")
	public Map<String,Object> getPosts(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage){
		
		//return postService.getPaginatedPosts(page,perPage);
		return postService.getPaginatedPosts(page, perPage);
	}
	
						
}
