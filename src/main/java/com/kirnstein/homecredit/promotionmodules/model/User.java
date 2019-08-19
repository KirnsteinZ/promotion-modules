package com.kirnstein.homecredit.promotionmodules.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{

	private static final long serialVersionUID = -8969616296055177123L;
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private long userId;

	@JoinColumn(name="pg_id",nullable=false)
	@ManyToOne
	private PromotionGroup promotionGroup;
	
	//Other user data needed for next phase or requirement

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public PromotionGroup getPromotionGroup() {
		return promotionGroup;
	}

	public void setPromotionGroup(PromotionGroup promotionGroup) {
		this.promotionGroup = promotionGroup;
	}
	
	//Other user data getter setter
}
