package com.estudo.estudo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.estudo.entities.Product;
import com.estudo.estudo.services.ProductServices;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductServices service;

	/*
	 * @GetMapping public ResponseEntity<Product> findAll() {
	 * 
	 * Product u = new Product(1L, "mariajoaquinha", "jeffersondecastro@gmail.com",
	 * "983491694", "1234565"); return ResponseEntity.ok().body(u); }
	 */

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
