package com.checklist.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checklist.models.ChecklistItem;


@Repository
@Transactional(rollbackFor = Exception.class)
public class ChecklistItemRepo {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(final ChecklistItem checklistItem) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(checklistItem);
	}

	public void update(final ChecklistItem checklistItem) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(checklistItem);
	}

	public ChecklistItem findById(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(ChecklistItem.class, id);
	}

	public void delete(final ChecklistItem checklistItem) {
		Session session = this.sessionFactory.getCurrentSession();		
		session.remove(checklistItem);
	}

	public List<ChecklistItem> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM User", ChecklistItem.class).getResultList();
	}

}
