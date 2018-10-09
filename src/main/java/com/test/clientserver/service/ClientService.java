package com.test.clientserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.clientserver.domain.Client;
import com.test.clientserver.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	/*
	 * Input Type	: String
	 * Output Type	: Client
	 * Description	: clientId를 통해 Client 정보를 조회하는 Service를 구현
	 */
	public Client selectClient(String clientId) {
		return clientRepository.findByClientId(clientId);
	}
}
