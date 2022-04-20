package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

public interface IClienteDao {

	List<Cliente> fiendAll();

	void save(Cliente cliente);

	Cliente findOne(Long id);

	void delete(Long id);

	@Query("select c from Cliente c left join fetch c.facturas f where c.id=?1") // Nos permite crear una consulta JPA más
																			// personalizada
	Cliente fetchByIdWithFacturas(Long id);
}
