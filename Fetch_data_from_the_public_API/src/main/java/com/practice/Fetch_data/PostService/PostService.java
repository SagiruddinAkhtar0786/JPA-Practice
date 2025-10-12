/**
 * 
 */
package com.practice.Fetch_data.PostService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practice.Fetch_data.Entity.Post;
import com.practice.Fetch_data.PostRepository.PostRepository;

/**
 * 
 */

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	private static final String API_URL = "https://jsonplaceholder.typicode.com/posts";
	
	public Map<String,Object> getPaginatedPosts(int page, int perPage){
		
		long totalCount = postRepository.count(); //means
		//if DB is empty ,fetch from public API
		System.out.println("total Count :: "+totalCount);
		if(totalCount == 0) {
			RestTemplate restTemplate = new RestTemplate();	
			Post[] posts = restTemplate.getForObject(API_URL,Post[].class);// means  This tells Spring what type of Java object the JSON response should be converted (mapped) into.
			System.out.println("Posts :: "+Arrays.toString(posts));
			
			
			
			if(posts != null) {
				int serialNo = 1;
				for(Post p : posts) {
					p.setSerialNumber(serialNo++);
				}
				postRepository.saveAll(Arrays.asList(posts));
				totalCount = posts.length;
			}
		}
		
		// Pagination logic
		
		int start  = (page - 1) * perPage;
		int end = start +perPage;
		
		List<Post> allPosts = postRepository.findAll();
		/*List<Post> paginatedPosts = allPosts.subList(
				Math.min(start, allPosts.size()),
				Math.max(end, allPosts.size())
				);*/
		
		List<Post> paginatedPosts = allPosts.subList(start,end);
		
		Map<String,Object> response = new HashMap<>();
		response.put("data", paginatedPosts);
		response.put("page", page);
		response.put("perpage", perPage);
		response.put("totalCount", totalCount);
		
		return response;
	}
	

}
