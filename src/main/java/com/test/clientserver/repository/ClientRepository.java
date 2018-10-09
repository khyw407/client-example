package com.test.clientserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.clientserver.domain.Client;

@RepositoryRestResource(path="/clients")
public interface ClientRepository extends JpaRepository<Client, Long>{
	Client findByClientId(String clientId);
}
