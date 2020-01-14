package com.springboot.mod4.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.mod4.app.dao.IClienteDao;

@Controller
public class ClienteController {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping(value = "/listar")
	public String listar(Map<String, Object> model) {
		model.put("titulo", "Lista de Clientes");
		model.put("clientes", clienteDao.findAll());
		return "listar";
	}
}
