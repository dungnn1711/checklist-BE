package com.checklist.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checklist.constances.Constances.ItemStatus;
import com.checklist.models.ChecklistItem;

@RestController
@CrossOrigin
@RequestMapping("/api/checklistitem")
public class ChecklistItemController {
	
private List<ChecklistItem> checklistItems;
	
	@PostConstruct
	public void init() {
		this.checklistItems = new ArrayList<ChecklistItem>();
		//
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		//
		for (int i = 0; i < 3; i++) {
			this.checklistItems.add(new ChecklistItem(i, "Check list item " + i, "Description item " + i, ids, ItemStatus.NOT_YET, 1));
		}
	}
	
	@GetMapping("")
	public ResponseEntity<List<ChecklistItem>> getAll() {
		return new ResponseEntity<List<ChecklistItem>>(this.checklistItems, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ChecklistItem> getChecklistItemById(@PathVariable int id) {
		for (ChecklistItem item : this.checklistItems) {
			if (id == item.getId()) {
				return new ResponseEntity<ChecklistItem>(item, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}
