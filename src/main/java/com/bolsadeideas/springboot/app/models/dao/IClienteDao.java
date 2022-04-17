package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

public interface IClienteDao {

	List<Cliente> fiendAll();

	void save(Cliente cliente);

	Cliente findOne(Long id);

}
