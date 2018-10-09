package com.test.clientserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.clientserver.domain.Client;
import com.test.clientserver.repository.ClientRepository;

/*
 * Description	: @SpringBootApplication은 스프링 부트 애플리케이션임을 나타내는 어노테이션이다.
 * 				    해당 어노테이션은 @Configuration, @EnableAutoConfiguration, @ComponentScan을 묶은 것이다.
 * 				  SpringApplicaion.run 메소드를 통해 스프링부트 애플리케이션을 실행시킨다. 
 */
@SpringBootApplication
public class ClientserverApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClientserverApplication.class, args);
	}
	
	/*
	 * Input Type	: CommandLineRunner
	 * Output Type	: ClientRepository
	 * Description	: CommanLineRunner 인터페이스는 구동 시점에 실행되는 코드가 자바 문자열 아규먼트 배열에 접근해야 할
	 * 				    필요가 있는 경우에 사용한다. 이렇게 구현된 메소드가 먼저 실행되고, 이후 main 메소드의 run 메소드가 실행된다.
	 */
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
