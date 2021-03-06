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
import com.checklist.models.ChecklistItem;
import com.checklist.models.User;
import com.checklist.services.impl.ChecklistItemServiceImpl;
import com.checklist.services.impl.ChecklistServiceImpl;
import com.checklist.services.impl.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/checklists")
public class ChecklistController {
	
	@Autowired
	private ChecklistServiceImpl checklistService;
	
	@GetMapping("")
	public ResponseEntity<List<Checklist>> getAll() {
		return new ResponseEntity<List<Checklist>>(checklistService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Checklist> getChecklistById(@PathVariable int id) {
		return new ResponseEntity<Checklist>(checklistService.findById(id), HttpStatus.OK);
	}
}
