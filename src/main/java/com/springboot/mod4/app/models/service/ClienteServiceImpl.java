package com.springboot.mod4.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.mod4.app.dao.IClienteDao;
import com.springboot.mod4.app.models.entities.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{
	

	@Autowired
	private IClienteDao clienteDaoImpl;
	
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		
		return clienteDaoImpl.findAll();
	}
	
	@Transactional
	@Override
	public void save(Cliente cliente) {
		
		clienteDaoImpl.save(cliente);
	}

	@Transactional(readOnly = true)
	@Override
	public Cliente findOne(Long id) {
		
		return clienteDaoImpl.findOne(id);
	}

	@Transactional
	@Override
	public void deleteOne(Long id) {
		
		clienteDaoImpl.deleteOne(id);
	}

}
