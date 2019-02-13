package com.chat.bapro.dao;

import java.util.List;

import com.chat.bapro.dto.UsuarioDto;
import com.chat.bapro.entity.Usuario;

public interface UsuarioDao {
	
	//crear un usuario
	public void creacionDeUsuario(Usuario usuario);
	
	//modificar un usuario
	public void modificacionDeUsuario(Usuario usuario);
	
	//buscar un usuario
	public Usuario buscarUnUsuario(long id);

	//eliminar un usuario
	public void eliminarUnUsuario(long id);
	
	//listar
	public List<Usuario> retornarTodosLosUsuarios();
}
