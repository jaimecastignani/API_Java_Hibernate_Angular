package com.escuela.main;

import com.escuela.dao.AlumnoDAO;
import com.escuela.dao.impl.AlumnoDAOHibernate;
import com.escuela.jpa.Alumno;

/**
 * @author
 */
public class MainApp {
	public static void main(String[] args) {
		AlumnoDAO alumnoDAO = new AlumnoDAOHibernate();
		Alumno alumno = new Alumno();
		alumno.setNombre("Test");
		alumno.setEdad(10);
		alumno.setCurso("Primero");
		alumnoDAO.create(alumno);
	}

}
