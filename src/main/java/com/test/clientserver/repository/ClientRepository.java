package com.test.clientserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.clientserver.domain.Client;

/*
 * Description : 스프링 데이터 리포지토리를 사용하여 clientId를 기반으로 Client 정보를 조회할 수 있도록 한다.
 */
@RepositoryRestResource(path="/clients")
public interface ClientRepository extends JpaRepository<Client, Long>{
	Client findByClientId(String clientId);
}
