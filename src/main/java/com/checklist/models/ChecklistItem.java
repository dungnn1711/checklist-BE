package com.checklist.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.checklist.constances.Constances.ItemStatus;

@Entity
public class ChecklistItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	private User admin;
	private List<Integer> followerIds;
	private ItemStatus status;
	private int checklistId;
	
	public ChecklistItem() {
		super();
	}

	public ChecklistItem(int id, String title, User admin, List<Integer> followerIds, ItemStatus status, int checklistId) {
		super();
		this.id = id;
		this.title = title;
		this.admin = admin;
		this.followerIds = followerIds;
		this.status = status;
		this.checklistId = checklistId;
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

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public ItemStatus getStatus() {
		return status;
	}

	public void setStatus(ItemStatus status) {
		this.status = status;
	}

	public int getChecklistId() {
		return checklistId;
	}

	public void setChecklistId(int checklistId) {
		this.checklistId = checklistId;
	}

	public List<Integer> getFollowerIds() {
		return followerIds;
	}

	public void setFollowerIds(List<Integer> followerIds) {
		this.followerIds = followerIds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + checklistId;
		result = prime * result + ((followerIds == null) ? 0 : followerIds.hashCode());
		result = prime * result + id;
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
		ChecklistItem other = (ChecklistItem) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (checklistId != other.checklistId)
			return false;
		if (followerIds == null) {
			if (other.followerIds != null)
				return false;
		} else if (!followerIds.equals(other.followerIds))
			return false;
		if (id != other.id)
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

	@Override
	public String toString() {
		return "ChecklistItem [id=" + id + ", title=" + title + ", admin=" + admin + ", followerIds=" + followerIds
				+ ", status=" + status + ", checklistId=" + checklistId + "]";
	}

}
