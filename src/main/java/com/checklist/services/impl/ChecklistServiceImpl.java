package com.checklist.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.checklist.models.Checklist;
import com.checklist.repositories.ChecklistRepo;
import com.checklist.services.ChecklistService;

@Service
@Transactional
public class ChecklistServiceImpl implements ChecklistService {

	@Autowired
	private ChecklistRepo checklistRepo;

	@Override
	public List<Checklist> findAll() {
		return checklistRepo.findAll();
	}

	@Override
	public Checklist findById(final int id) {
		Checklist checklist = checklistRepo.getById((Integer)id);
		return checklist;
	}

	@Override
	public void save(final Checklist checklist) {
		checklistRepo.save(checklist);
	}

	@Override
	public void update(final Checklist checklist) throws NotFound {
		Checklist _checklist = checklistRepo.getById(checklist.getId());
		if (_checklist != null) {
			checklistRepo.save(checklist);
		}
	}

	@Override
	public void delete(final int id) {
		Checklist checklist = checklistRepo.getById(id);
		if (checklist != null) {
			checklistRepo.delete(checklist);
		}
	}

}
