package com.checklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checklist.models.User;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Integer> {}
