package com.rajesh.spring.cloud.poc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/discounts")
public class DiscountsController {
	
	@Value("${product.url}")
	private String url;
	
	@GetMapping("/{id}")
	public Long getDiscount( @PathVariable int id ) {
	url=url+id;
	System.out.println(" URL is : "+url);
	RestTemplate restTemplate=new RestTemplate();
			Product result=restTemplate.getForObject(url, Product.class);
			System.out.println("Product Name "+result.getProductId()+ " product type "+result.getProductType());
			if(result.getProductType().equalsIgnoreCase("electronics")) 
				return new Long(10);
			
			else if(result.getProductType().equalsIgnoreCase("grocery")) 
					return new Long(15);			
			else 	
				return new Long(0);	
	}
}
