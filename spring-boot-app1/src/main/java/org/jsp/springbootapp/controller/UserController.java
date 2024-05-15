package org.jsp.springbootapp.controller;

import java.util.List;
import org.jsp.springbootapp.dto.ResponseStructure;
import org.jsp.springbootapp.dto.User;
import org.jsp.springbootapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PutMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {

		return userService.saveUser(user);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> findById(@PathVariable(name = "id") int id) {
		return userService.findById(id);

	}

	@GetMapping("/findbyname/{name}")

	public ResponseEntity<ResponseStructure<List<User>>> findByName(@PathVariable(name = "name") String name) {
		return userService.findByName(name);
	}

	@GetMapping("/findbyemail/{email}")
	public ResponseEntity<ResponseStructure<User>> findByEmail(@PathVariable(name = "email") String email) {
		return userService.findByEmail(email);
	}

	@GetMapping("/findbyphone/{phone}")
	public ResponseEntity<ResponseStructure<User>> findByPhone(@PathVariable(name = "phone") long phone) {
		return userService.findByPhone(phone);
	}

}
