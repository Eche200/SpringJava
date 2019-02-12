package com.chat.bapro.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuarios_del_chat")
public class Usuario implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name = "id")
	private long id;
	
	@Column(name="nombre")
	@NotEmpty//valida que el campo no este vacio
	private String nombre;
	
	@Column(name="apellido")
	@NotEmpty//valida que el campo no este vacio
	private String apellido;
	
	@Column(name="nombre_de_usuario")
	@NotEmpty//valida que el campo no este vacio
	private String nombreDeUsuario;
	
	@Column(name="correo_electronico")
	@NotEmpty//valida que el campo no este vacio	
	private String correoElectronico;
	
	
	
	@Column(name="fecha_de_nacimiento")
	@NotNull//valida que el campo no este vacio
	private String fechaDeNacimiento;
	
	
	
	
	@Column(name="creado_en")
	@NotNull//valida que el campo no este vacio
	private String fechaDeCreacionDeCuenta;




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}




	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}




	public String getCorreoElectronico() {
		return correoElectronico;
	}




	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}




	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}




	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}




	public String getFechaDeCreacionDeCuenta() {
		return fechaDeCreacionDeCuenta;
	}




	public void setFechaDeCreacionDeCuenta(String fechaDeCreacionDeCuenta) {
		this.fechaDeCreacionDeCuenta = fechaDeCreacionDeCuenta;
	}
	
	
	
	
	
	

}
