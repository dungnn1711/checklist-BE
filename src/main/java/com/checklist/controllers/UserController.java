package com.checklist.controllers;

import java.util.ArrayList;
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

import com.checklist.constances.Constances.ItemStatus;
import com.checklist.constances.Constances.UserRole;
import com.checklist.models.Checklist;
import com.checklist.models.User;
import com.checklist.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

	private List<User> users;
	
	@Autowired
	private UserService userService;
	
//	@PostConstruct
//	public void init() {
//		this.users = new ArrayList<User>();
//
//		for (int i = 0; i < 3; i++) {
//			this.users.add(new User(i, "Nguyen", "Van A" + i, new Date(1999, 10, i), "url..." + i, "Eng 1", "Group 1", UserRole.STANDARD_USER));
//		}
//	}
	
	@GetMapping("")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		for (User user : users) {
			if (id == user.getId()) {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
