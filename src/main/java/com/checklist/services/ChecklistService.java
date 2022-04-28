package com.checklist.services;

import java.util.List;

import com.checklist.models.Checklist;

public interface ChecklistService {
	List<Checklist> findAll();
	Checklist findById(final int id);
	void save(final Checklist checklist);
	void update(final Checklist checklist);
	void delete(final int id);
}
