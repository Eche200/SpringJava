package com.chat.bapro.dto;




public class UsuarioDto {
	
	private long id;
	private String nombre;
	private String apellido;
	private String nombreDeUsuario;
	private String correoElectronico;
	private String fechaDeNacimiento;
	private String fechaDeCreacionDeCuenta;
	private String idSeleccionado;
	
	
	
	
	

	public String getIdSeleccionado() {
		return idSeleccionado;
	}
	public void setIdSeleccionado(String idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}
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
