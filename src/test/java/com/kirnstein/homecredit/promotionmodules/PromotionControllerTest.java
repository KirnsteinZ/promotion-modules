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

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PromotionModulesApplicationTests.class})
public class PromotionControllerTest {
	
	@Autowired
	private PromotionController promotionController;
	

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
