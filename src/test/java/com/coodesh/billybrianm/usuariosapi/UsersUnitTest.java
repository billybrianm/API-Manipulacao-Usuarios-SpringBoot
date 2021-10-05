package com.coodesh.billybrianm.usuariosapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.coodesh.billybrianm.usuariosapi.repositories.UserRepository;
import com.coodesh.billybrianm.usuariosapi.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
class UsersUnitTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    UserRepository userRepository;
    
	
	@Test
	public void testServiceNotNull() {
		Assertions.assertNotNull(userService);
	}
	
	@Test
	public void testScheduledRandomUsers() {
		
		Assertions.assertEquals(2000, userService.getRandomUsers());
	}
	
	@Test
	public void testSeedForRandomUsers() {
		Assertions.assertEquals(userService.generateRandomSeed(5).length(), 5);
	}
	
}
