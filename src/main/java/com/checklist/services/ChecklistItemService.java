package com.checklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checklist.models.Checklist;
import com.checklist.models.ChecklistItem;
import com.checklist.models.User;
import com.checklist.repositories.ChecklistItemRepo;
import com.checklist.repositories.ChecklistRepo;
import com.checklist.repositories.UserRepo;

@Service
@Transactional
public class ChecklistItemService {

	@Autowired
	private ChecklistItemRepo checklistItemRepo;

	public List<ChecklistItem> findAll() {
		return checklistItemRepo.findAll();
	}

	public ChecklistItem findById(final int id) {
		return checklistItemRepo.findById(id);
	}

	public void save(final ChecklistItem checklistItem) {
		checklistItemRepo.save(checklistItem);
	}

	public void update(final ChecklistItem checklistItem) {
		checklistItemRepo.update(checklistItem);
	}

	public void delete(final int id) {
		ChecklistItem checklistItem = checklistItemRepo.findById(id);
		if (checklistItem != null) {
			checklistItemRepo.delete(checklistItem);
		}
	}

}
