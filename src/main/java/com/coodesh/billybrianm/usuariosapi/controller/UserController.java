package com.coodesh.billybrianm.usuariosapi.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coodesh.billybrianm.usuariosapi.model.User;
import com.coodesh.billybrianm.usuariosapi.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
		
	
	@GetMapping
	public ResponseEntity<String> getMessage() {
		return new ResponseEntity<>("REST Back-end Challenge 20201209 Running", HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> users = new ArrayList<User>();
			
			users = userService.list();
			
			if(users.isEmpty()) {
				logger.log(Level.INFO, "Nenhum usuário encontrado.");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(users, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("Erro interno do servidor ao buscar usuários.");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") long id) {
		try {
			
			Optional<User> user = userService.find(id);
			
			if(user.isEmpty()) {
				logger.log(Level.INFO, "O usuário especificado não foi encontrado.");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("Erro interno do servidor ao buscar usuários.");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			User _user = userService.save(user); 
					
					
			logger.log(Level.INFO, "Novo usuário inserido na base.");
			return new ResponseEntity<>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Erro interno do servidor ao inserir usuário.");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, User user) {
		try {
			user.setUserid(id);
			User _user = userService.save(user);
			
			logger.log(Level.INFO, "Usuário atualizado com sucesso.");
			return new ResponseEntity<>(_user, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("Erro ao atualizar o usuário recebido.");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
		try {
			boolean deleted = userService.delete(id);
			
			if(deleted) {
				logger.log(Level.INFO, "Usuário removido com sucesso.");
				return new ResponseEntity<>(null, HttpStatus.OK);
			} else {
				logger.log(Level.INFO, "Erro ao remover usuário.");
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			logger.error("Erro ao atualizar o usuário recebido.");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/usersget")
	public ResponseEntity<String> getty() {
		try {
			
			int userCount = userService.getRandomUsers();
						
			return new ResponseEntity<String>(userCount + " usuários buscados com sucesso.", HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("Erro interno do servidor ao buscar usuários.");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
