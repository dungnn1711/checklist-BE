package com.checklist.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.checklist.models.ChecklistItem;
import com.checklist.repositories.ChecklistItemRepo;
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
		return checklistItemRepo.getById(id);
	}

	@Override
	public void save(final ChecklistItem checklistItem) {
		checklistItemRepo.save(checklistItem);
	}

	@Override
	public void update(final ChecklistItem checklistItem) throws NotFound {
		ChecklistItem _checklistItem = checklistItemRepo.getById(checklistItem.getId());
		if (_checklistItem != null) {
			checklistItemRepo.save(checklistItem);
		}
	}

	@Override
	public void delete(final int id) {
		ChecklistItem checklistItem = checklistItemRepo.getById(id);
		if (checklistItem != null) {
			checklistItemRepo.delete(checklistItem);
		}
	}

}
