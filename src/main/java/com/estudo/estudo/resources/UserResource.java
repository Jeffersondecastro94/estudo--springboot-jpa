package com.estudo.estudo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.estudo.entities.User;
import com.estudo.estudo.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserServices service;

	/*
	 * @GetMapping public ResponseEntity<User> findAll() {
	 * 
	 * User u = new User(1L, "mariajoaquinha", "jeffersondecastro@gmail.com",
	 * "983491694", "1234565"); return ResponseEntity.ok().body(u); }
	 */

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
