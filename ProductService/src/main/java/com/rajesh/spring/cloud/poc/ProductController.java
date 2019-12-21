package com.rajesh.spring.cloud.poc;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductDao pdao;
	
	@PostMapping("/createProduct")
	public Product createProduct(@RequestBody Product product) {	
		return pdao.save(product);
	}
	
	@GetMapping("/getProduct/{id}")
	public Product getProduct(@PathVariable Long id) {
		
	return	pdao.findById(id).get();
				
	}
	
	@GetMapping(value ="/getAllProdcuts")
	public List<Product> getProducts(){
		return  (List<Product>) pdao.findAll();
	}
	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@RequestBody Product newproduct,@PathVariable Long id) {
		return pdao.findById(id).map(product->{
		product.setProductId(newproduct.getProductId());
		product.setProductName(newproduct.getProductName());
		product.setProductType(newproduct.getProductType());
		return pdao.save(product);
		}).orElseGet(()->{
			newproduct.setProductId(id);
			return pdao.save(newproduct);
		});
		
	}

}
