package com.escuela.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "alumno")
@XmlRootElement(name = "alumno")
public class Alumno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6973877800802243760L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alumno", updatable = false, nullable = false)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long idAlumno;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Column(name = "curso")
	private int curso;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Column(name = "edad")
	private int edad;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Column(name = "nombre")
	private String nombre;

	public Alumno() {
	}

	public Alumno(Long idAlumno, int curso, int edad, String nombre) {
		this.idAlumno = idAlumno;
		this.curso = curso;
		this.edad = edad;
		this.nombre = nombre;
	}

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Alumno [idAlumno=" + idAlumno + ", nombre=" + nombre + ", edad=" + edad + ", curso=" + curso + "]";
	}

}
