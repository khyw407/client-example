package com.test.clientserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.clientserver.domain.Client;
import com.test.clientserver.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("/client/{clientId}")
	@ResponseBody
	public ResponseEntity<Client> getClient(@PathVariable String clientId){
		ResponseEntity<Client> re = new ResponseEntity<>(clientService.selectClient(clientId), HttpStatus.OK);
		return re;
	}
}
