package com.escuela.dao;

import java.util.List;

import com.escuela.jpa.Alumno;

/**
 * @author
 *
 */
public interface AlumnoDAO {

	public void create(Alumno alumno);

	public Alumno update(Alumno alumno);

	public void delete(Long id);

	public List<Alumno> getAll();

	public Alumno findById(Long id);

}
