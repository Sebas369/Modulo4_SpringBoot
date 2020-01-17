package com.springboot.mod4.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.mod4.app.models.entities.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
}
