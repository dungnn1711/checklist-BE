package com.checklist.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checklist.constances.Constances.ItemStatus;
import com.checklist.models.CheckList;
import com.checklist.models.User;

@RestController
@RequestMapping("/api/checklist")
public class ChecklistController {

	private List<CheckList> checklist;
	
	@PostConstruct
	public void init() {
		this.checklist = new ArrayList<CheckList>();
		List<User> users = new ArrayList<>();
		for (int j = 0; j < 3; j++) {
			users.add(new User(j, "Nguyen Van " + j, new Date(1997, 11, j), "url" + j));
		}
		for (int i = 0; i < 3; i++) {
			this.checklist.add(new CheckList(i, users, "title " + i, "description..." + i, ItemStatus.DONE));
		}
	}
	
	@GetMapping("")
	public ResponseEntity<List<CheckList>> getAll() {
		return new ResponseEntity<List<CheckList>>(this.checklist, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CheckList> getChecklistById(@PathVariable int id) {
		for (CheckList item : checklist) {
			if (id == item.getId()) {
				return new ResponseEntity<CheckList>(item, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
