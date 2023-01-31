package com.estudo.estudo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.estudo.entities.Category;
import com.estudo.estudo.services.CategoryServices;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryServices service;

	/*
	 * @GetMapping public ResponseEntity<Category> findAll() {
	 * 
	 * Category u = new Category(1L, "mariajoaquinha", "jeffersondecastro@gmail.com",
	 * "983491694", "1234565"); return ResponseEntity.ok().body(u); }
	 */

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
