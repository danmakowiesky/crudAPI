package com.api.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.crud.api.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
