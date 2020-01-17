package com.springboot.mod4.app.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.springboot.mod4.app.models.entities.Cliente;
import com.springboot.mod4.app.models.service.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping(value = "/listar")
	public String listar(Map<String, Object> model) {
		model.put("titulo", "Lista de Clientes");
		model.put("clientes", clienteService.findAll());
		return "listar";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String guardar(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("titulo", "Agregar Cliente");
		model.put("cliente", cliente);
		return "form";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		Optional<Cliente> cliente = null;

		if (id > 0) {
			cliente = clienteService.findOne(id);
		} else {
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "form";

	}

	@RequestMapping(value = "/remove/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		if (id > 0) {
			clienteService.deleteOne(id);
		}
		return "redirect:/listar";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {

		model.addAttribute("titulo", "Agregar Cliente");
		if (result.hasErrors()) {
			return "form";
		}
		clienteService.save(cliente);
		status.setComplete();
		return "redirect:/listar";
	}
}
