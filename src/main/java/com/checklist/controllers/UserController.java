package com.checklist.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@GetMapping("")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable int id) {
		return new ResponseEntity<Optional<User>>(userService.findById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteUserById(@PathVariable int id) {
		boolean isDeleted = userService.delete(id);
		if (isDeleted) {
			return HttpStatus.OK;
		} else {
			return HttpStatus.EXPECTATION_FAILED;
		}
	}
}
