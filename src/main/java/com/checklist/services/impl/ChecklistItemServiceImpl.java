package com.checklist.services.impl;

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
import com.checklist.services.ChecklistItemService;

@Service
@Transactional
public class ChecklistItemServiceImpl implements ChecklistItemService{

	@Autowired
	private ChecklistItemRepo checklistItemRepo;

	@Override
	public List<ChecklistItem> findAll() {
		return checklistItemRepo.findAll();
	}

	@Override
	public ChecklistItem findById(final int id) {
		return checklistItemRepo.findById(id);
	}

	@Override
	public void save(final ChecklistItem checklistItem) {
		checklistItemRepo.save(checklistItem);
	}

	@Override
	public void update(final ChecklistItem checklistItem) {
		checklistItemRepo.update(checklistItem);
	}

	@Override
	public void delete(final int id) {
		ChecklistItem checklistItem = checklistItemRepo.findById(id);
		if (checklistItem != null) {
			checklistItemRepo.delete(checklistItem);
		}
	}

}
