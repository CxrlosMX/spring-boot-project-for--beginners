package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Producto;

public interface IClienteService {
	List<Cliente> fiendAll();

	void save(Cliente cliente);

	Cliente findOne(Long id);

	void delete(Long id);

	List<Producto> findByNombre(String term);
}
