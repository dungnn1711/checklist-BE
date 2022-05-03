package com.checklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checklist.models.ChecklistItem;


@Repository
@Transactional(rollbackFor = Exception.class)
public interface ChecklistItemRepo extends JpaRepository<ChecklistItem, Integer> {}
