package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Repository // Atonacion que indica que es un acceso a datos
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext // Realizamos la inyección
	private EntityManager em; // Se encarga de manejar las entidades, el ciclo de vida, nos permite crear
								// consultas etc pero nos retorna objetos

	@SuppressWarnings("unchecked") // Para remover algun tipo de warnin
	@Override
	public List<Cliente> fiendAll() {

		return em.createQuery("from Cliente").getResultList();
	}

}
