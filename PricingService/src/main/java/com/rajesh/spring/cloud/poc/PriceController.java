package com.rajesh.spring.cloud.poc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceController {
	@RequestMapping("/{productId}")
	public Integer getPrice(@PathVariable Integer productId) {
		if(productId==1) {
			return 100;		}
		
		return 2;
	}
}
