package com.test.clientserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.clientserver.domain.Client;
import com.test.clientserver.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	public Client selectClient(String clientId) {
		return clientRepository.findByClientId(clientId);
	}
}
