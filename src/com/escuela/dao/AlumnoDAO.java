package com.escuela.dao;

import java.util.ArrayList;

import com.escuela.jpa.Alumno;

/**
 * @author
 *
 */
public interface AlumnoDAO {

	public void create(Long id, String name, int age, String curso);

	public void update(Long id, String name, int age, String curso);

	public void delete(Long id);

	public ArrayList<Alumno> getAll();

}
