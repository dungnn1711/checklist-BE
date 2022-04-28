package com.checklist.services;

import java.util.List;

import com.checklist.models.User;

public interface UserService {
	List<User> findAll();
	User findById(final int id);
	void save(final User user);
	void update(final User user);
	void delete(final int id);
}
