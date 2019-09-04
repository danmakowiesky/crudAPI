package com.api.crud.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.api.documents.Cliente;
import com.api.crud.api.services.ClienteService;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {
	@Autowired
	private ClienteService clientService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarTodos(){
		return ResponseEntity.ok(this.clientService.listarTodos());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Cliente>> listarPorId(@PathVariable(name= "id") String id){
		return ResponseEntity.ok(this.clientService.listarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){
		return ResponseEntity.ok(this.clientService.cadastrar(cliente));
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable(name= "id") String id,@RequestBody Cliente cliente){
		cliente.setId(id);
		return ResponseEntity.ok(this.clientService.atualizar(cliente));
	}
	
	@DeleteMapping(path = "/deleteuser/{id}")
	public ResponseEntity<String> remover(@PathVariable(name= "id") String id){
		this.clientService.remover(id);
		return ResponseEntity.ok("Removido");
	}
}
