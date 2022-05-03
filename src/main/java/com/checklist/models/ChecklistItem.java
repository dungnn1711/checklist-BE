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
@Table(name = "checklist_item")
public class ChecklistItem implements Serializable {
	
	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private ItemStatus status;
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinColumn
//	private List<User> followers;
	
	public ChecklistItem() {
		super();
	}

	public ChecklistItem(String title, String description, ItemStatus status) {
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

}
