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
import com.checklist.models.Checklist;
import com.checklist.services.ChecklistService;

@RestController
@CrossOrigin
@RequestMapping("/api/checklist")
public class ChecklistController {

	private List<Checklist> checklist;
	
	@Autowired
	private ChecklistService checklistService;
	
//	@PostConstruct
//	public void init() {
//		this.checklist = new ArrayList<Checklist>();
//		//
//		List<Integer> ids = new ArrayList<>();
//		ids.add(1);
//		ids.add(2);
//		ids.add(3);
//		//
//		String now = java.time.LocalDate.now().toString();
//		//
//		for (int i = 0; i < 3; i++) {
//			this.checklist.add(new Checklist(i, ids, "Checklist " + i, "Description " + i, ItemStatus.NOT_YET, new Date(2022, 1, 1), null, 1, 1));
//		}
//	}
	
	@GetMapping("")
	public ResponseEntity<List<Checklist>> getAll() {
		return new ResponseEntity<List<Checklist>>(checklistService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Checklist> getChecklistById(@PathVariable int id) {
		for (Checklist item : checklist) {
			if (id == item.getId()) {
				return new ResponseEntity<Checklist>(item, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
