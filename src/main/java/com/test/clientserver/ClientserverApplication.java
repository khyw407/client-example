package com.test.clientserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.clientserver.domain.Client;
import com.test.clientserver.repository.ClientRepository;

@SpringBootApplication
public class ClientserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientserverApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
		return args -> {
			Client client = new Client();
			
			client.setSeq(1);
			client.setClientId("client1");
			client.setClientSecret("test1");
			client.setAuthorizedGrantTypes("password");
			client.setScope("read");
			client.setAutoApproveScopes("read");
			client.setAccessTokenValiditySeconds(1000 * 60 * 5);
			client.setRefreshTokenValiditySeconds(1000 * 60 * 5);
			client.setAuthorities("ROLE_CLIENT");
			client.setResourceIds("");
			client.setRegisteredRedirectUris("");
			clientRepository.save(client);
		};
	}
}
