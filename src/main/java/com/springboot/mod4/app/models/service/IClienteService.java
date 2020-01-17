package com.springboot.mod4.app.models.service;

import java.util.List;
import java.util.Optional;

import com.springboot.mod4.app.models.entities.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();

	public void save(Cliente cliente);

	public Optional<Cliente> findOne(Long id);

	public void deleteOne(Long id);
}
