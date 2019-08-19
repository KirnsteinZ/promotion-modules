package com.kirnstein.homecredit.promotionmodules.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kirnstein.homecredit.promotionmodules.helper.ModuleResponse;
import com.kirnstein.homecredit.promotionmodules.model.ModuleRelation;
import com.kirnstein.homecredit.promotionmodules.model.PromotionGroup;
import com.kirnstein.homecredit.promotionmodules.model.User;
import com.kirnstein.homecredit.promotionmodules.repo.ModuleRelationRepository;
import com.kirnstein.homecredit.promotionmodules.repo.PromotionalGroupRepository;
import com.kirnstein.homecredit.promotionmodules.repo.UserRepository;

@RestController
public class PromotionController {

	@Autowired UserRepository userRepo;
	@Autowired PromotionalGroupRepository pgRepo;
	@Autowired ModuleRelationRepository mrRepo;
	
	@GetMapping("/modules")
	public ResponseEntity<Map<String,ArrayList<ModuleResponse>>> getModuleByUser(@RequestParam Long userId){
		Optional<User> userResult = userRepo.findById(userId);
		Map<String,ArrayList<ModuleResponse>> result = new HashMap<>();
		result.put("modules", new ArrayList<>());
		if(userResult.isPresent()) {
			long pgId = userResult.get().getPromotionGroup().getPromotionGroupId();
			Optional<PromotionGroup> pgResult = pgRepo.findById(pgId);
			if(pgResult.isPresent()) {
				ArrayList<ModuleRelation> fr = mrRepo.findByIdPromotionGroupPromotionGroupIdOrderByIdSequenceAsc(pgId);
				ArrayList<ModuleResponse> list = new ArrayList<ModuleResponse>();
				for (ModuleRelation mr : fr) {
					list.add(new ModuleResponse(mr.getModule().getModuleName(), mr.getId().getSequence()));
				}
				result.put("modules", list);
			}
		}
		return new ResponseEntity<Map<String,ArrayList<ModuleResponse>>>(result, HttpStatus.OK);
	}
	
}
