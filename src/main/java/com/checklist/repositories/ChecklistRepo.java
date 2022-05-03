package com.checklist.repositories;


import java.util.HashSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checklist.models.Checklist;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface ChecklistRepo extends JpaRepository<Checklist, Integer> {
	
	HashSet<Checklist> findByFollowers_Id(int Followers_Id);

}
