package com.checklist.services;

import java.util.List;

import com.checklist.models.Checklist;
import com.checklist.models.ChecklistItem;

public interface ChecklistItemService {
	List<ChecklistItem> findAll();
	ChecklistItem findById(final int id);
	void save(final ChecklistItem checklistItem);
	void update(final ChecklistItem checklistItem);
	void delete(final int id);
}
