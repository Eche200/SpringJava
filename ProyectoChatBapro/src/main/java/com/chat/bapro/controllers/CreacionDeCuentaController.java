package com.chat.bapro.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.chat.bapro.dao.IUsuarioDao;
import com.chat.bapro.dto.UsuarioDto;
import com.chat.bapro.entity.Usuario;

@Controller
public class CreacionDeCuentaController {
	
	@Autowired
	@Qualifier(value="IUsuarioDao")
	private IUsuarioDao iUsuarioDao ;
	
	
	
	//alta nuevo usuario inicio
	@RequestMapping(value="/nuevoUsuario" , method=RequestMethod.POST)
	public String metodoPostAltaNuevoUsuario (@Valid UsuarioDto usuarioDto , BindingResult validador )
	{
		
		String retorno = "nuevoUsuario";
		
		Usuario usuario = new Usuario();
		
	
		
		if(validaciones(usuarioDto) != null)
		{
			
			usuario.setApellido(usuarioDto.getApellido());
			usuario.setNombre(usuarioDto.getNombre());
			usuario.setNombreDeUsuario(usuarioDto.getNombreDeUsuario());
			usuario.setCorreoElectronico(usuarioDto.getCorreoElectronico());
			usuario.setFechaDeNacimiento(usuarioDto.getFechaDeCreacionDeCuenta());
			usuario.setFechaDeCreacionDeCuenta(usuarioDto.getFechaDeCreacionDeCuenta());
			try {
				
			this.iUsuarioDao.creacionDeUsuario(usuario);
			retorno = "redirect:/";
			}catch(Exception e)
			{
				e.getMessage();
			}
		}
		return retorno;
	}
	
	
	//modelo view  lo que le paso
	@GetMapping("/nuevoUsuario")
	public String ModelViewNuevoUsuario (Map<String, Object> modelo)
	{
		UsuarioDto usuario = new UsuarioDto();
		modelo.put("usuario", usuario);
		
		return "nuevoUsuario";
	}
	
	
	
	
	
	public UsuarioDto validaciones(UsuarioDto usuarioDto)
	{
		UsuarioDto retorno = null;
		
		if( !(usuarioDto.getApellido().equals(null) && usuarioDto.getApellido().equals("")) ||
				!(usuarioDto.getNombre().equals(null) && usuarioDto.getNombre().equals("")) ||
				!(usuarioDto.getCorreoElectronico().equals(null) && usuarioDto.getCorreoElectronico().equals("")) ||
				!(usuarioDto.getNombreDeUsuario().equals(null) && usuarioDto.getNombreDeUsuario().equals("")))
		{
			
			retorno = usuarioDto;
			
		}
		
		return retorno;
	}
	
	//alta nuevo usuario fin
	
	//index inicio (esto tengo que cambiar a un nuev lugar)
	@GetMapping("/")
	public String modelViewIndex (Map<String, Object> modelo)
	{
		
		return "index";
	}
	
	
	//index fin
	
	//elegirIdModificar inicio
	@GetMapping("/elegirIdModificar")
	public String modelViewElegirId (Map<String, Object> modelo)
	{
		UsuarioDto usuarioDto = new UsuarioDto();
		modelo.put("usuarioDto",usuarioDto);
		
		return "elegirIdModificar";
	}
	
	
	@RequestMapping(value="/elegirIdModificar" , method=RequestMethod.POST)
	public String metodoPostElegirIdModificar (@Valid UsuarioDto usuarioDto)
	{
		
		String retorno = "elegirIdModificar";
		Map<String , Object> modelo = new HashMap<String, Object>();
		Usuario nuevoUsuarioDto = null;
		int numero= Integer.parseInt(usuarioDto.getIdSeleccionado());
		nuevoUsuarioDto = iUsuarioDao.buscarUnUsuario(Long.parseLong(usuarioDto.getIdSeleccionado()));
	
		
		if(nuevoUsuarioDto != null)
		{
			usuarioDto.setId(nuevoUsuarioDto.getId());
			usuarioDto.setApellido(nuevoUsuarioDto.getApellido());
			usuarioDto.setNombre(nuevoUsuarioDto.getNombre());
			usuarioDto.setCorreoElectronico(nuevoUsuarioDto.getCorreoElectronico());
			usuarioDto.setFechaDeCreacionDeCuenta(nuevoUsuarioDto.getFechaDeCreacionDeCuenta());
			usuarioDto.setFechaDeNacimiento(nuevoUsuarioDto.getFechaDeNacimiento());
			usuarioDto.setNombreDeUsuario(nuevoUsuarioDto.getNombreDeUsuario());
			
			modelo.put("usuarioDto", usuarioDto);
			
			
			retorno = "modificacionUsuario";
		}
		return retorno;
	}
	
	
	//elegirIdModificar fin
	
	
	
	//eliminar usuario inicio
	@RequestMapping(value="/elegirIdEliminar" , method= RequestMethod.POST)
	public String metodoPostEliminarUsuario (@Valid UsuarioDto usuarioDto)
	{
		String retorno = "elegirIdEliminar";
		if(usuarioDto != null)
		{
		
			iUsuarioDao.eliminarUnUsuario(Long.parseLong(usuarioDto.getIdSeleccionado()));
			retorno= "index";
		}
		
		
		
	
		return retorno;
	}
	
	@GetMapping("/elegirIdEliminar")
	public String modelViewElegirIdEliminar (Map<String, Object> modelo)
	{
		UsuarioDto usuarioDto = new UsuarioDto();
		modelo.put("usuarioDto", usuarioDto);
		
		return "elegirIdEliminar";
	}
	
	
	
	
	
	
	//eliminar usuario fin
	
	
	
	//modificacion usuario inicio
	@RequestMapping(value="/modificacionUsuario" , method= RequestMethod.POST)
	public String metodoPostModificacionUsuario (@Valid UsuarioDto usuarioDto)
	{
		String retorno = "modificacionUsuario";
		Usuario usuario = new Usuario();
		if(validarModificacionUsuario(usuarioDto) != null)
		{
			usuario.setApellido(usuarioDto.getApellido());
			usuario.setCorreoElectronico(usuarioDto.getCorreoElectronico());
			usuario.setFechaDeCreacionDeCuenta(usuarioDto.getFechaDeCreacionDeCuenta());
			usuario.setFechaDeNacimiento(usuarioDto.getFechaDeNacimiento());
			usuario.setNombre(usuarioDto.getNombre());
			usuario.setNombreDeUsuario(usuarioDto.getNombreDeUsuario());
			usuario.setId(usuarioDto.getId());
			iUsuarioDao.modificacionDeUsuario(usuario);
			
			retorno = "index";
			//FALTAN COSAS!!
		}
		
		
		
		
		
		return retorno;
	}
	
	@GetMapping(value="/modificacionUsuario")
	public String modelViewModificacionUsuario(UsuarioDto usuarioDto,	Map<String, Object> modelo)
	{
		String retorno = "redirect:/";
		
		
			modelo.put("usuarioDto", usuarioDto);
			retorno = "modificacionUsuario";
		
		
		
		
		
		return retorno;
	}
	
	
	
	private UsuarioDto validarModificacionUsuario (UsuarioDto usuarioDto)
	{
		UsuarioDto retorno = null;
		
		if(!(usuarioDto.getApellido().equals(null) && usuarioDto.getApellido().equals("")) ||
				!(usuarioDto.getNombre().equals(null) && usuarioDto.getNombre().equals("")) ||
				!(usuarioDto.getCorreoElectronico().equals(null) && usuarioDto.getCorreoElectronico().equals("")) ||
				!(usuarioDto.getNombreDeUsuario().equals(null) && usuarioDto.getNombreDeUsuario().equals(""))||
				!(usuarioDto.getFechaDeCreacionDeCuenta().equals(null) && usuarioDto.getFechaDeCreacionDeCuenta().equals(""))||
				!(usuarioDto.getFechaDeNacimiento().equals(null) && usuarioDto.getFechaDeNacimiento().equals(""))
				)
		{
			retorno = usuarioDto;
		}
		
		return retorno;
	}
	
	//modificacion fin
	

}
