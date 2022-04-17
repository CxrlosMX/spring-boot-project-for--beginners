package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Controller // Para marcar la clase como un controlador
public class ClienteController {

	@Autowired // Con esta anotación busca algun componente que implemente la interface
				// IClienteDao
	// Si tenemos más de un componente que implemente la interface, se especifica
	// con: @Qualifier("nombreComponente")
	@Qualifier("clienteDaoJPA")
	private IClienteDao clienteDao; // Siempre es importante buscar lo más generico para mejorar el CEO o
									// actulizaciones a futuro

	@GetMapping("/listar") // Especificamos el método y la ruta
	public String listar(Model model) { // El objeto Model para pasar datos a la vista
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteDao.fiendAll()); // Lo pasamos a la vista
		return "listar";
	}

	// INSERCIÓN
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "Formulario de Cliente");
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		return "form"; // Nombre de la vistas
	}

	@PostMapping("/form")
	public String guardar(Cliente cliente) {
		clienteDao.save(cliente);
		return "redirect:listar";
	}

}
