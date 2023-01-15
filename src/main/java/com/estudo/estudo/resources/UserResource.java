package com.estudo.estudo.resources;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.estudo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {

		User u = new User(1L, "mariajoaquinha", "jeffersondecastro@gmail.com", "983491694", "1234565");
		return ResponseEntity.ok().body(u);
	}
}
