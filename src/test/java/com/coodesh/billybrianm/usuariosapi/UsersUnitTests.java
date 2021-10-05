package com.coodesh.billybrianm.usuariosapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.coodesh.billybrianm.usuariosapi.enums.StatusEnum;
import com.coodesh.billybrianm.usuariosapi.model.Coordinates;
import com.coodesh.billybrianm.usuariosapi.model.DateOfBirth;
import com.coodesh.billybrianm.usuariosapi.model.Identifier;
import com.coodesh.billybrianm.usuariosapi.model.Location;
import com.coodesh.billybrianm.usuariosapi.model.Login;
import com.coodesh.billybrianm.usuariosapi.model.Name;
import com.coodesh.billybrianm.usuariosapi.model.Picture;
import com.coodesh.billybrianm.usuariosapi.model.Registered;
import com.coodesh.billybrianm.usuariosapi.model.Street;
import com.coodesh.billybrianm.usuariosapi.model.Timezone;
import com.coodesh.billybrianm.usuariosapi.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class UsersUnitTests {
	
	@Autowired
    private MockMvc mockMvc;

	@Test
	@Order(1)
	public void contextLoad() {
		assertNotNull(mockMvc);
	}
	
	@Test
	@Order(2)
	public void testCreateUser() throws Exception {
		User user = userToCreate();
		this.mockMvc.perform(TestRequestAPIKeyFactory.post("/users").contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(new ObjectMapper().registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).writeValueAsString(user))).andExpect(status().isCreated());
	}
	
	@Test
	@Order(3)
	public void testUpdateUser() throws Exception {
		User user = userToUpdate();
		this.mockMvc.perform(TestRequestAPIKeyFactory.put("/users").contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(new ObjectMapper().registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).writeValueAsString(user))).andExpect(status().isCreated());
	}
	
	private User userToCreate() {	
		Name name = new Name("Miss", "Tess", "Boyer");
		Location location = new Location(new Street(4331, "Place du 8 Février 1962"), "Rennes", "Haute-Saône", "France", "13595", new Coordinates("0.6778", "127.0293"), new Timezone("-3:30", "Newfoundland"));
		Login login = new Login("f12464c6-09f5-4d9d-bb02-0c1e5d91fa0e", "blackbird805", "51505150", "J7v1LZUT", "a6372e56b718cafae887fff7c48b7f07", "f66f35c58e340b11648e9dc1de9e66a32da96df7", "ca1b1f8868ab94ae5359e50e31c1c790e51f862b5c61a38ce28dfd466d6c7a9d");
		DateOfBirth dob = new DateOfBirth(LocalDateTime.of(1948, 9, 19, 7, 39), 73);
		Registered registered = new Registered(LocalDateTime.of(2017, 12, 23, 1, 27), 4);
		Identifier id = new Identifier("INSEE", "2NNaN25139949 90");
		Picture picture = new Picture("https://randomuser.me/api/portraits/women/33.jpg", "https://randomuser.me/api/portraits/med/women/33.jpg", "https://randomuser.me/api/portraits/thumb/women/33.jpg");
		User u = new User(20030L, "female", name, location, "tess.boyer@example.com", login, dob, registered, "05-60-96-09-09", "06-99-08-80-75", id, picture, "FR", Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()), StatusEnum.PUBLISHED);
						
		
		return u;
	}
	
	private User userToUpdate() {		
		User u = new User();
		
		u.setGender("female");
		
		return u;
	}
    

}
