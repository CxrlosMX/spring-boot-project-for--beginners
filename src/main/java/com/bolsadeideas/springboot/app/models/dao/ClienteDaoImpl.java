package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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
	@Transactional  
	public void save(Cliente cliente) {
		em.persist(cliente);
	}
}
