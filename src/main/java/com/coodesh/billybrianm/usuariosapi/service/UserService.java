package com.coodesh.billybrianm.usuariosapi.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coodesh.billybrianm.usuariosapi.enums.StatusEnum;
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
		
		userRepository.deleteById(id);
		return true;		
	}
	
	public Integer getRandomUsers() {
				
	    List<User> users = new ArrayList<>();
		String url = "";
		int i = 0;
		int count = 0;
		String generatedString = generateRandomSeed(4);
		
		// busca os dados uma página de cada vez, de 100 em 100 até completar os 2000
		for(i = 0; i < 20; i++) {
	        url = "https://randomuser.me/api/?page="+i+"&results=100&seed="+generatedString;
	        
	        String json = this.restTemplate.getForObject(url, String.class);
	        
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.registerModule(new JavaTimeModule());
	        
	        try {
	        	// acessa o ponto results na árvore do json e busca os objetos como lista de users
				users = mapper.convertValue(mapper.readTree(json).get("results"), new TypeReference<List<User>>() {}); 
				
				for(User u : users) {
					u.setImported_t(new Date());
					u.setStatus(StatusEnum.PUBLISHED);
					count++;
				}
				
				userRepository.saveAll(users);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
        
        return count;
    }
	
	public String generateRandomSeed(Integer size) {
		byte[] array = new byte[size]; // gera uma string com digitos aleatórios para ser a seed da api
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    
	    return generatedString;
	}

}
