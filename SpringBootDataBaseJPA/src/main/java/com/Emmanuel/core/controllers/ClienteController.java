package com.Emmanuel.core.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Emmanuel.core.model.dao.IClienteDao;
import com.Emmanuel.core.model.entity.Cliente;

@Controller
public class ClienteController {
	
	@Autowired//aca va a buscar una clase BEAN que este implementando ICLIENTEDAO , en este caso ClienteDaoImplement
	//@Qualifier("nombre del Bean") asi le puedo especificar que Bean quiero usar  , si es que varios bean usan el mismo Dao
	//el mismo Bean debe tener en su @Repository un nombre entre ("")
	@Qualifier(value="ClienteDaoImplement")//este bean debe ser un DaoImplement , no el dao solo
	private IClienteDao clienteDao;
	
	@Value("${application.controller.home}")
	private String navBarHome;
	
	@RequestMapping(value = "/listar" , method=RequestMethod.GET)//puede ir getmapping
	public String listar(Model modelo)
	{
		modelo.addAttribute("titulo" , "Mis clases de Spring");
		modelo.addAttribute("clientes",clienteDao.retornarTodosLosClientes());
		modelo.addAttribute("home", this.navBarHome);
		return "listar";
	}
	
	@GetMapping("/formulario")
	public String insertarEnBaseDeDatos(Map<String , Object> modelo)
	{
		Cliente cliente = new Cliente();
		modelo.put("cliente", cliente);
		modelo.put("titulo" , "formulario de cliente");
		return "formulario";
	}
	
	
	@RequestMapping(value="/formulario" , method=RequestMethod.POST)
	public String metodoPost(@Valid Cliente cliente , BindingResult validador) //el bindingResult vamos a usaro para ver si hubo error con las validaciones que  le pusismos en el objetocliente , como notnul por ejemplo
	{
		String retorno="redirect:listar";
		if( validador.hasErrors() )
		{
			retorno="formulario";//cuando quiero que muestre los errores , pongo  el nombre directo , sin el redirect
		}
		else
		{
			guardar(cliente);			
		}
		
		
		return retorno;
	}
	
	
	//@RequestMapping(value="/formulario" , method=RequestMethod.POST)
	public void guardar(Cliente cliente)
	{
		clienteDao.guardarCliente(cliente);
		
	}
}
