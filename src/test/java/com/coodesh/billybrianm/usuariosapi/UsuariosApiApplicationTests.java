package com.coodesh.billybrianm.usuariosapi;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coodesh.billybrianm.usuariosapi.model.User;
import com.coodesh.billybrianm.usuariosapi.service.UserService;

@SpringBootTest
class UsuariosApiApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
    private UserService userService;

    @Test
    public void testGetUsers() {
        List<User> users= userService.list();

        assertEquals(users.size(), 1);
    }
}
