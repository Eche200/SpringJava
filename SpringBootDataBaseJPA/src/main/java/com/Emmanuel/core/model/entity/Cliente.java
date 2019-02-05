package com.Emmanuel.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="clientes_original")
public class Cliente  implements Serializable{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name="nombre")
	@NotEmpty//valida que el campo no este vacio
	private String nombre;
	
	@Column(name="apellido")
	@NotEmpty//valida que el campo no este vacio
	private String apellido;
	
	@Column(name="correo_electronico")
	@NotEmpty//valida que el campo no este vacio
	private String correoElectronico;
	
	@Column(name="creado_en")
	@Temporal(TemporalType.DATE)
	@NotNull//valida que el campo no este vacio
	@DateTimeFormat(pattern="yyyy-mm-dd")//esto es para convertir a  un formato
	private Date creadoEn;

	
	//este metodo prePersist, lo hacemos , cuando queremos agregar una fecha de creacion , y esto lo hace de  forma automatica
	
	
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Date getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(Date creadoEn) {
		this.creadoEn = creadoEn;
	}
	
	
	
	
	
	

}
