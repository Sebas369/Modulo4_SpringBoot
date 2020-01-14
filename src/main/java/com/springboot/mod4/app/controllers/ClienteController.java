package com.springboot.mod4.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.mod4.app.dao.IClienteDao;
import com.springboot.mod4.app.models.entities.Cliente;

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
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String guardar(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("titulo", "Agregar Cliente");
		model.put("cliente", cliente);
		return "form";
	}
	
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String guardar(Cliente cliente) {
		clienteDao.save(cliente);
		return "redirect:listar";
	}
}
