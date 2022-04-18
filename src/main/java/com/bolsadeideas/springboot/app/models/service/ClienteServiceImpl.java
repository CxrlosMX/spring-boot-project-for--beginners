package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private IClienteDao clienteDao;


	@Override
	public List<Cliente> fiendAll() {
		// TODO Auto-generated method stub
		return clienteDao.fiendAll();
	}

	@Override
	public void save(Cliente cliente) {
		clienteDao.save(cliente);

	}


	@Override
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findOne(id);
	}


	@Override
	public void delete(Long id) {
		clienteDao.delete(id);

	}

}