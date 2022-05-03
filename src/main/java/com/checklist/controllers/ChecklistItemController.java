package com.checklist.controllers;

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
import com.checklist.models.ChecklistItem;
import com.checklist.services.impl.ChecklistItemServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/checklistitems")
public class ChecklistItemController {
	
	@Autowired
	private ChecklistItemServiceImpl checklistItemService;
	
	@GetMapping("")
	public ResponseEntity<List<ChecklistItem>> getAll() {
		return new ResponseEntity<List<ChecklistItem>>(checklistItemService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ChecklistItem> getChecklistItemById(@PathVariable int id) {
		return new ResponseEntity<ChecklistItem>(checklistItemService.findById(id), HttpStatus.OK);
	}

}
