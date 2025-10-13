package com.practice.ACID_Transaction.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.ACID_Transaction.Service.ShopService;

@RestController
@RequestMapping("/shop")
public class ShopController {
	
	private final ShopService shopService;
	
	public ShopController(ShopService shopService ) {
		this.shopService =shopService;
	}
	
	@PostMapping("/order")
	public String placeOrder(@RequestParam Long userId,
			@RequestParam Long productId,
			@RequestParam Double amount) {
		
		shopService.placeOrder(userId, productId, amount);
		
		return "order placed Sucessfully";
	}
	

}
