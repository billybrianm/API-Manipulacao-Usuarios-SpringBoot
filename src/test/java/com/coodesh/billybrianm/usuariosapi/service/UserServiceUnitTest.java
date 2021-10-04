package com.coodesh.billybrianm.usuariosapi.service;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coodesh.billybrianm.usuariosapi.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceUnitTest {
	
	@Autowired
    private UserService userService;

    @Test
    public void testGetUsers() {
        List<User> users= userService.list();

        Assert.assertEquals(users.size(), 0);
    }

}
