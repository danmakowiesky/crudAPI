package com.api.crud.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.api.documents.Cliente;
import com.api.crud.api.repositories.ClienteRepository;
import com.api.crud.api.services.ClienteService;


@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRespository;

	@Override
	public List<Cliente> listarTodos() {
		return this.clienteRespository.findAll();
	}

	@Override
	public Optional<Cliente> listarPorId(String id) {
		return this.clienteRespository.findById(id);
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		return this.clienteRespository.save(cliente);
	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		return this.clienteRespository.save(cliente);
	}

	@Override
	public void remover(String id) {
		this.clienteRespository.deleteById(id);
	}

}
