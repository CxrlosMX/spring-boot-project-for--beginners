package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
		//Video 132- 5:23
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Repository("clienteDaoJPA") // Atonacion que indica que es un acceso a datos, Con comillas especificamos un
								// nombre de acceso
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext // Realizamos la inyección
	private EntityManager em; // Se encarga de manejar las entidades, el ciclo de vida, nos permite crear
								// consultas etc pero nos retorna objetos

	@SuppressWarnings("unchecked") // Para remover algun tipo de warnin
	@Override
	public List<Cliente> fiendAll() {

		return em.createQuery("from Cliente").getResultList();
	}

	/*
	 * TODO PARA GUARDAR UN CLIENTE persist(Object entity): Almacena un objeto
	 * entity en el contexto de persistencia y en la base de datos
	 */
	@Override
	public void save(Cliente cliente) {
		if (cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente); // El método merge() lo que hace es actualizar los datos existentes
		} else {
			em.persist(cliente);
		}
	}

	// ACTUALIZAR -EDITAR
	@Override
	public Cliente findOne(Long id) {

		return em.find(Cliente.class, id); // De forma automatica JPA va a la base de datos y nos entrega el objeto
											// cliente
	}

	// ELIMINAR- DELETE
	@Override
	public void delete(Long id) {
		// Obtenemos el cliente
		Cliente cliente = findOne(id); // Buscamos el cliente

		em.remove(cliente); // Eliminamos el cliente

	}
}
