package com.checklist.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checklist.models.User;
import com.checklist.repositories.UserRepo;
import com.checklist.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User findById(final int id) {
		return userRepo.findById(id);
	}

	@Override
	public void save(final User user) {
		userRepo.save(user);
	}

	@Override
	public void update(final User user) {
		userRepo.update(user);
	}

	@Override
	public void delete(final int id) {
		User user = userRepo.findById(id);
		if (user != null) {
			userRepo.delete(user);
		}
	}

}
