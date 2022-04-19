package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.dao.IProductoDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Producto;

@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private IClienteDao clienteDao;

	@Autowired
	private IProductoDao productoDao;

	@Override
	@Transactional
	public List<Cliente> fiendAll() {
		// TODO Auto-generated method stub
		return clienteDao.fiendAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);

	}

	@Override
	@Transactional
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.delete(id);

	}

	@Override
	@Transactional
	public List<Producto> findByNombre(String term) {
		// TODO Auto-generated method stub
		return productoDao.findByNombre(term);
	}

}
