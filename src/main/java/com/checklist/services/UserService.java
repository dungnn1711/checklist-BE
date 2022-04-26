package com.checklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checklist.models.User;
import com.checklist.repositories.UserRepo;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findById(final int id) {
		return userRepo.findById(id);
	}

	public void save(final User user) {
		userRepo.save(user);
	}

	public void update(final User user) {
		userRepo.update(user);
	}

	public void delete(final int id) {
		User user = userRepo.findById(id);
		if (user != null) {
			userRepo.delete(user);
		}
	}

}
