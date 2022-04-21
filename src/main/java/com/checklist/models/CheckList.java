package com.checklist.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.checklist.constances.Constances.ItemStatus;

@Entity
public class Checklist {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private List<Integer> followerIds;
	private String title;
	private String description;
	private ItemStatus status;
	private Date registerDate;
	private Date completeDate;
	private int interval;
	private int adminId;
	
	public Checklist() {
		super();
	}

	public Checklist(int id, List<Integer> followerIds, String title, String description, ItemStatus status, Date registerDate,
			Date completeDate, int interval, int adminId) {
		super();
		this.id = id;
		this.followerIds = followerIds;
		this.title = title;
		this.description = description;
		this.status = status;
		this.registerDate = registerDate;
		this.completeDate = completeDate;
		this.interval = interval;
		this.adminId = adminId;
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

	public List<Integer> getFollowerIds() {
		return followerIds;
	}

	public void setFollowerIds(List<Integer> followerIds) {
		this.followerIds = followerIds;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminId;
		result = prime * result + ((completeDate == null) ? 0 : completeDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((followerIds == null) ? 0 : followerIds.hashCode());
		result = prime * result + id;
		result = prime * result + interval;
		result = prime * result + ((registerDate == null) ? 0 : registerDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Checklist other = (Checklist) obj;
		if (adminId != other.adminId)
			return false;
		if (completeDate == null) {
			if (other.completeDate != null)
				return false;
		} else if (!completeDate.equals(other.completeDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (followerIds == null) {
			if (other.followerIds != null)
				return false;
		} else if (!followerIds.equals(other.followerIds))
			return false;
		if (id != other.id)
			return false;
		if (interval != other.interval)
			return false;
		if (registerDate == null) {
			if (other.registerDate != null)
				return false;
		} else if (!registerDate.equals(other.registerDate))
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
