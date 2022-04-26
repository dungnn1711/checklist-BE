package com.checklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checklist.models.Checklist;
import com.checklist.models.User;
import com.checklist.repositories.ChecklistRepo;
import com.checklist.repositories.UserRepo;

@Service
@Transactional
public class ChecklistService {

	@Autowired
	private ChecklistRepo checklistRepo;

	public List<Checklist> findAll() {
		return checklistRepo.findAll();
	}

	public Checklist findById(final int id) {
		return checklistRepo.findById(id);
	}

	public void save(final Checklist checklist) {
		checklistRepo.save(checklist);
	}

	public void update(final Checklist checklist) {
		checklistRepo.update(checklist);
	}

	public void delete(final int id) {
		Checklist checklist = checklistRepo.findById(id);
		if (checklist != null) {
			checklistRepo.delete(checklist);
		}
	}

}
