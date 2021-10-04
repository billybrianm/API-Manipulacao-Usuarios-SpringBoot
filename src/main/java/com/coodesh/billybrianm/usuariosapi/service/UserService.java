package com.coodesh.billybrianm.usuariosapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coodesh.billybrianm.usuariosapi.model.User;
import com.coodesh.billybrianm.usuariosapi.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	public List<User> list() {
        return userRepository.findAll();
    }
	
	public User save(User u) {
		return userRepository.save(u);
	}

}
