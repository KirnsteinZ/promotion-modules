package com.kirnstein.homecredit.promotionmodules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kirnstein.homecredit.promotionmodules.controller.PromotionController;
import com.kirnstein.homecredit.promotionmodules.helper.ModuleResponse;
import com.kirnstein.homecredit.promotionmodules.repo.ModuleRelationRepository;
import com.kirnstein.homecredit.promotionmodules.repo.PromotionalGroupRepository;
import com.kirnstein.homecredit.promotionmodules.repo.UserRepository;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PromotionModulesApplicationTests.class})
public class PromotionControllerTest {
	
	@Autowired PromotionController promotionController;
	
	@Autowired UserRepository userRepository;
	@Autowired PromotionalGroupRepository promotionalGroupRepository;
	@Autowired ModuleRelationRepository moduleRelationRepository;

	@Test
	public void userRepositoryTest() {
		assertNotNull(userRepository);
		assertTrue(userRepository.count()==3);
		assertTrue(userRepository.findById(1L).get().getPromotionGroup().getPromotionGroupId() == 1L);
		assertTrue(userRepository.findById(2L).get().getPromotionGroup().getPromotionGroupId() == 2L);
		assertTrue(userRepository.findById(3L).get().getPromotionGroup().getPromotionGroupId() == 3L);
	}
	
	@Test
	public void promotionalGroupRepositoryTest() {
		assertNotNull(promotionalGroupRepository);
		assertTrue(promotionalGroupRepository.count()==3);
		assertTrue(promotionalGroupRepository.findById(1L).get().getUserList().size()==1);
		assertTrue(promotionalGroupRepository.findById(2L).get().getUserList().size()==1);
		assertTrue(promotionalGroupRepository.findById(3L).get().getUserList().size()==1);
	}
	
	@Test
	public void moduleRelationRepositoryTest() {
		assertNotNull(moduleRelationRepository);
		assertTrue(moduleRelationRepository.count()==15);
		assertTrue(moduleRelationRepository.findByIdPromotionGroupPromotionGroupIdOrderByIdSequenceAsc(1L).size()==5);
		assertTrue(moduleRelationRepository.findByIdPromotionGroupPromotionGroupIdOrderByIdSequenceAsc(2L).size()==5);
		assertTrue(moduleRelationRepository.findByIdPromotionGroupPromotionGroupIdOrderByIdSequenceAsc(3L).size()==5);
		assertTrue(moduleRelationRepository.findByIdPromotionGroupPromotionGroupIdOrderByIdSequenceAsc(1L).get(0).getId().getSequence()==1L);
		assertTrue(moduleRelationRepository.findByIdPromotionGroupPromotionGroupIdOrderByIdSequenceAsc(1L).get(0).getModule().getModuleId()==1L);
		assertTrue(moduleRelationRepository.findByIdPromotionGroupPromotionGroupIdOrderByIdSequenceAsc(2L).get(1).getId().getSequence()==2L);
		assertTrue(moduleRelationRepository.findByIdPromotionGroupPromotionGroupIdOrderByIdSequenceAsc(2L).get(1).getModule().getModuleId()==5L);
		assertTrue(moduleRelationRepository.findByIdPromotionGroupPromotionGroupIdOrderByIdSequenceAsc(3L).get(4).getId().getSequence()==5L);
		assertTrue(moduleRelationRepository.findByIdPromotionGroupPromotionGroupIdOrderByIdSequenceAsc(3L).get(4).getModule().getModuleId()==4L);
	}
	
	
	@Test
	public void getModuleByUser_Test_Positive() {
		ResponseEntity<Map<String, ArrayList<ModuleResponse>>> result =  promotionController.getModuleByUser(1L);
		assertNotNull(result);
		assertEquals(result.getStatusCode(), HttpStatus.OK);
		assertTrue(result.getBody().containsKey("modules"));
		assertNotNull(result.getBody().get("modules"));
		assertTrue(result.getBody().get("modules").size()==5);
	}
}
