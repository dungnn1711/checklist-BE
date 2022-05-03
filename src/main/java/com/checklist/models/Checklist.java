package com.checklist.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.checklist.constances.Constances.ItemStatus;

@Entity(name = "Checklist")
@Table(name = "checklist")
public class Checklist implements Serializable {
	
	private static final long serialVersionUID = 3L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
//	@org.hibernate.annotations.ForeignKey(name = "none")
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@Fetch(value = FetchMode.SUBSELECT)
//	@Cascade(value= {org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
	@JoinTable(name="checklist_user")
	private List<User> followers;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private ItemStatus status;
	@Column(name = "register_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date registerDate;
	@Column(name = "complete_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date completeDate;
	@Column
	private int interval;
	@OneToOne
	@JoinColumn(name="author_id")
	private User author;
	@Column
	@ManyToMany(fetch = FetchType.EAGER)
	private List<ChecklistItem> items;
	
	public Checklist() {
		super();
	}

	public Checklist(List<User> followers, String title, String description, ItemStatus status, Date registerDate,
			Date completeDate, int interval, User author, List<ChecklistItem> items) {
		super();
		this.followers = followers;
		this.title = title;
		this.description = description;
		this.status = status;
		this.registerDate = registerDate;
		this.completeDate = completeDate;
		this.interval = interval;
		this.author = author;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
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

	public ItemStatus getStatus() {
		return status;
	}

	public void setStatus(ItemStatus status) {
		this.status = status;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User admin) {
		this.author = admin;
	}

	public List<ChecklistItem> getItems() {
		return items;
	}

	public void setItems(List<ChecklistItem> items) {
		this.items = items;
	}
	
}
