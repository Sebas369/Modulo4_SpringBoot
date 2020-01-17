package com.springboot.mod4.app.dao;

import java.util.List;

import com.springboot.mod4.app.models.entities.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
}
