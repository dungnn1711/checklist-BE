package com.checklist.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checklist.models.Checklist;
import com.checklist.models.User;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ChecklistRepo {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(final Checklist checklist) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(checklist);
	}

	public void update(final Checklist checklist) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(checklist);
	}

	public Checklist findById(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Checklist.class, id);
	}

	public void delete(final Checklist checklist) {
		Session session = this.sessionFactory.getCurrentSession();		
		session.remove(checklist);
	}

	public List<Checklist> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM User", Checklist.class).getResultList();
	}

}
