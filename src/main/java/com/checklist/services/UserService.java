package com.checklist.services;

import java.util.List;
import java.util.Optional;

import com.checklist.models.User;

public interface UserService {
	List<User> findAll();
	Optional<User> findById(final int id);
	void save(final User user);
	void update(final User user);
	boolean delete(final int id);
}
