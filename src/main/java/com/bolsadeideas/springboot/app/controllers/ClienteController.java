package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.service.ClienteServiceImpl;

@Controller // Para marcar la clase como un controlador
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired // Con esta anotación busca algun componente que implemente la interface
				// IClienteDao
	// Si tenemos más de un componente que implemente la interface, se especifica
	// con: @Qualifier("nombreComponente")
	// @Qualifier("clienteDaoJPA")
	private ClienteServiceImpl clienteService; // Siempre es importante buscar lo más generico para mejorar el CEO o
	// actulizaciones a futuro

	// Método para ver los datos de un cliente
	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Cliente cliente = clienteService.findOne(id); // Obtenemos el cliente
		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}
		model.put("titulo", "Detalle Cliente");
		model.put("cliente", cliente);
		return "ver";
	}

	@GetMapping("/listar") // Especificamos el método y la ruta
	public String listar(Model model) { // El objeto Model para pasar datos a la vista
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteService.fiendAll()); // Lo pasamos a la vista
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
	public String guardar(Cliente cliente, SessionStatus status) {
		clienteService.save(cliente);
		status.setComplete();
		return "redirect:/listar";
	}

	// ACTUALIZAR - EDITAR
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Cliente cliente = null;
		model.put("titulo", "Editar Cliente");
		if (id > 0) {
			cliente = clienteService.findOne(id);
		} else {
			return "redirect:/listar"; // En caso que el id sea igual o menor a cero , nos redirige a la vista "listar"
		}
		model.put("cliente", cliente); // Pasamos el cliente a la vista
		return "form";
	}

	// DELETE - ELIMINAR
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id > 0) { // Si el ID es mayor a cero
			clienteService.delete(id); // Eliminamos
		}

		return "redirect:/listar"; // Al eliminar redireccionar a la vista "listar"
	}

}
