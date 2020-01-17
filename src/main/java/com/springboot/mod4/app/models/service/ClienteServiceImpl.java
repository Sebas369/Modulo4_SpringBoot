package com.springboot.mod4.app.models.service;

import java.util.List;
import java.util.Optional;

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
		
		return (List<Cliente>) clienteDaoImpl.findAll();
	}
	
	@Transactional
	@Override
	public void save(Cliente cliente) {
		
		clienteDaoImpl.save(cliente);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Cliente> findOne(Long id) {
		
		return clienteDaoImpl.findById(id);
	}

	@Transactional
	@Override
	public void deleteOne(Long id) {
		
		clienteDaoImpl.deleteById(id);
	}

}
