package com.checklist.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checklist.constances.Constances.UserRole;
import com.checklist.models.User;
import com.checklist.services.impl.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
//	@PostConstruct
//	public void init() {
//		for(int i = 0; i < 10; i++) {
//			userService.save(new User("Nguyen", "Van A" + i, new Date(1997, 5, i), "url..." + i, "Eng 1", "Group 1", UserRole.STANDARD_USER));
//		}
//	}
	
	@GetMapping("")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}
}
