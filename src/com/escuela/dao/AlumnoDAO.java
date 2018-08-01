package com.escuela.dao;

import java.util.ArrayList;

import com.escuela.jpa.Alumno;

/**
 * @author
 *
 */
public interface AlumnoDAO {

	public void create(Alumno alumno);

	public void update(Alumno alumno);

	public void delete(Long id);

	public ArrayList<Alumno> getAll();

}
