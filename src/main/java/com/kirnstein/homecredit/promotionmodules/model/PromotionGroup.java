package com.kirnstein.homecredit.promotionmodules.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="promotion_group")
public class PromotionGroup implements Serializable{

	private static final long serialVersionUID = 6525159785048720612L;

	@JsonIgnore
	@Id
	@GeneratedValue
	@Column(name="pg_id")
	private long promotionGroupId;

	@JsonIgnore
	@OneToMany(mappedBy="promotionGroup",fetch = FetchType.EAGER)
	private Set<User> userList;
	
	//Other promotion group info

	public long getPromotionGroupId() {
		return promotionGroupId;
	}

	public void setPromotionGroupId(long promotionGroupId) {
		this.promotionGroupId = promotionGroupId;
	}

	public Set<User> getUserList() {
		return userList;
	}

	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}

	//Other promotion group info getter setter
	
}
