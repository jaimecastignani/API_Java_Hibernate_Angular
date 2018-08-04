package com.escuela.dto;

import com.escuela.jpa.Alumno;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONException;
import org.json.JSONObject;

@XmlRootElement
public class AlumnoDTO {
	@XmlElement(name = "idAlumno")
	private Long idAlumno;
	@XmlElement(name = "curso")
	private int curso;
	@XmlElement(name = "edad")
	private int edad;
	@XmlElement(name = "nombre")
	private String nombre;

	public AlumnoDTO(Alumno alumno) {
		this.idAlumno = alumno.getIdAlumno();
		this.curso = alumno.getCurso();
		this.edad = alumno.getEdad();
		this.nombre = alumno.getNombre();
	}

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		try {
			JSONObject main = new JSONObject();
			main.put("Command", "CreateNewUser");
			JSONObject alumno = new JSONObject();
			alumno.put("idAlumno", idAlumno);
			alumno.put("edad", edad);
			alumno.put("curso", curso);
			alumno.put("nombre", nombre);
			return new JSONObject().put("alumno", alumno).toString();
		} catch (JSONException e) {
			return null;
		}
	}
}
