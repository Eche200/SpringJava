package com.Emmanuel.core.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Emmanuel.core.model.entity.Cliente;


@Repository(value="ClienteDaoImplement")
public class ClienteDaoImplement implements IClienteDao{

	@PersistenceContext
	private EntityManager entity;
	
	
	@SuppressWarnings("unchecked")//esto es para sacar una advertencia
	@Transactional(readOnly=true)//esto porque es solo de lectura , si fuera de insercion , esta notacion no va
	@Override
	public List<Cliente> retornarTodosLosClientes() {
		
		return entity.createQuery("from Cliente").getResultList();
	}
	
	@Transactional
	public void guardarCliente(Cliente cliente)
	{
		entity.persist(cliente);
	}
	

}
