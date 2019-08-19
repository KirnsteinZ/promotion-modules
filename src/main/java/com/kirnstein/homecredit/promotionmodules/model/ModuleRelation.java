package com.kirnstein.homecredit.promotionmodules.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="module_relation")
public class ModuleRelation implements Serializable{

	public ModuleRelation() {}
	
	public ModuleRelation(ModuleRelationId id, Module module) {
		super();
		this.id = id;
		this.module = module;
	}

	private static final long serialVersionUID = -3680745803816703662L;
	
	@EmbeddedId
	private ModuleRelationId id;

	@JoinColumn(name="module_id",nullable = true)
	@ManyToOne
	public Module module;
	
	@Embeddable
	public static class ModuleRelationId implements Serializable{
		
		public ModuleRelationId() {}
		
		public ModuleRelationId(PromotionGroup promotionGroup, int sequence) {
			super();
			this.promotionGroup = promotionGroup;
			this.sequence = sequence;
		}

		private static final long serialVersionUID = -3543883005384191362L;
	
		@JoinColumn(name="pg_id", nullable = false)
		@ManyToOne
		public PromotionGroup promotionGroup;
		
		@Column
		public int sequence;
		
		public PromotionGroup getPromotionGroup() {
			return promotionGroup;
		}

		public void setPromotionGroup(PromotionGroup promotionGroup) {
			this.promotionGroup = promotionGroup;
		}

		public int getSequence() {
			return sequence;
		}

		public void setSequence(int sequence) {
			this.sequence = sequence;
		}

		@Override
		public int hashCode() {
			return Objects.hash(toString());
		}
		
		@Override
		public String toString() {
			return promotionGroup.getPromotionGroupId() +"S"+sequence;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj == null) return false;
			if(!(obj instanceof ModuleRelationId)) return false;
			ModuleRelationId other = (ModuleRelationId) obj;
			return Objects.equals(other.getPromotionGroup(), promotionGroup)
					&& Objects.equals(other.getSequence(), sequence);
		}
	}

	public ModuleRelationId getId() {
		return id;
	}

	public void setId(ModuleRelationId id) {
		this.id = id;
	}
	
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return "ModuleRelation [id=" + id + ", module=" + module + "]";
	}
}
