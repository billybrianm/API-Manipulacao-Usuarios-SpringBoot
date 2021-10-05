package com.coodesh.billybrianm.usuariosapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coodesh.billybrianm.usuariosapi.model.User;
import com.coodesh.billybrianm.usuariosapi.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	private final RestTemplate restTemplate;
	
	public UserService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
	public List<User> list() {
        return userRepository.findAll();
    }
	
	public User save(User u) {
		return userRepository.save(u);
	}
	
	public Optional<User> find(long id) {
		return userRepository.findById(id);
	}
	
	public boolean delete(long id) {
		Optional<User> u = find(id);
		
		if(u.isEmpty())
			return false;
		
		userRepository.delete(u.get());
		return true;		
	}
	
	public List<User> getRandomUsers() {
		
		List<User> users = new ArrayList<>();
        String url = "https://randomuser.me/api?results=2000";
        
        String json = this.restTemplate.getForObject(url, String.class);
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        
        try {
        	// acessa o ponto results na árvore do json e busca os objetos como lista de users
			users = mapper.convertValue(mapper.readTree(json).get("results"), new TypeReference<List<User>>() {}); 
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        
        return users;
    }

}
