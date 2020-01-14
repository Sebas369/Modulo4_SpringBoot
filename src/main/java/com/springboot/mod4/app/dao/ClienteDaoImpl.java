package com.springboot.mod4.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.mod4.app.models.entities.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao {
	
	@Autowired
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		
		return em.createQuery("from Cliente").getResultList();
	}

	@Transactional
	@Override
	public void save(Cliente cliente) {
		em.persist(cliente);
		
	}

}
