package com.Emmanuel.core.model.dao;

import java.util.List;

import com.Emmanuel.core.model.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> retornarTodosLosClientes();
	
	public void guardarCliente(Cliente cliente);

}
