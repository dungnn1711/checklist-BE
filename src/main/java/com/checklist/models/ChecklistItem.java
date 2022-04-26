package com.checklist.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.checklist.constances.Constances.ItemStatus;

@Entity(name = "ChecklistItem")
@Table(name = "checklistItem")
public class ChecklistItem implements Serializable {
	
	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String title;
	@Column(nullable=true)
	private String description;
	@Column(nullable=false)
	private ItemStatus status;
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinColumn
//	private List<User> followers;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn
//	private Checklist checklist;
	
	public ChecklistItem() {
		super();
	}

	public ChecklistItem(String title, String description, ItemStatus status, Checklist checklist) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public List<User> getFollowers() {
//		return followers;
//	}
//
//	public void setFollowers(List<User> followers) {
//		this.followers = followers;
//	}

	public ItemStatus getStatus() {
		return status;
	}

	public void setStatus(ItemStatus status) {
		this.status = status;
	}

//	public Checklist getChecklist() {
//		return checklist;
//	}
//
//	public void setChecklist(Checklist checklist) {
//		this.checklist = checklist;
//	}

}
