package com.coodesh.billybrianm.usuariosapi.scheduling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.coodesh.billybrianm.usuariosapi.controller.UserController;
import com.coodesh.billybrianm.usuariosapi.service.UserService;

@Component
public class TimedTasks {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	@Scheduled(cron = "${cron.buscarandom}")
	public void buscarRandom() {
		int count = 0;
		
		logger.info("Iniciando busca dos usuários aleatórios...");	
		
		try {
			count = userService.getRandomUsers();
		} catch (Exception e) {
			logger.error("Erro ao buscar usuários aleatórios às 8H: ", e.getLocalizedMessage());
		}
			    
	    logger.info(count + " usuários foram buscados.");
	}
}
