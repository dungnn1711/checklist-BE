package com.checklist.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.checklist.models.Checklist;
import com.checklist.models.User;
import com.checklist.repositories.ChecklistRepo;
import com.checklist.repositories.UserRepo;
import com.checklist.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ChecklistRepo checklistRepo;

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> findById(final int id) {
		return userRepo.findById(id);
	}

	@Override
	public void save(final User user) {
		userRepo.save(user);
	}

	@Override
	public void update(final User user) throws NotFound {
		Optional<User> _user = userRepo.findById(user.getId());
		if (_user != null) {
			userRepo.save(user);
		}
	}

	@Override
	public boolean delete(final int id) {
		try {
//			HashSet<Checklist> checklists = checklistRepo.findByFollowers_Id(id);
//			for (Checklist checklist : checklists) {
//				checklist.getFollowers().remove(id);
//				checklistRepo.save(checklist);
//			}

			userRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
