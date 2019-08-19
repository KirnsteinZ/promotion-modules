package com.kirnstein.homecredit.promotionmodules.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirnstein.homecredit.promotionmodules.model.ModuleRelation;
import com.kirnstein.homecredit.promotionmodules.model.ModuleRelation.ModuleRelationId;

public interface ModuleRelationRepository extends JpaRepository<ModuleRelation, ModuleRelationId>{

	ArrayList<ModuleRelation> findByIdPromotionGroupPromotionGroupIdOrderByIdSequenceAsc(Long promotionGroupId);
}
