package com.escuela.dao.impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.escuela.dao.AlumnoDAO;
import com.escuela.jpa.Alumno;

public class AlumnoDAOHibernate implements AlumnoDAO {
	// Create an EntityManagerFactory when you start the application.
	//private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("PERSISTENCE");

	@PersistenceContext(unitName = "PERSISTENCE")
	private static EntityManager manager;
	
	@Override
	public void create(Long id, String name, int age, String curso) {
		// Create an EntityManager
		//EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Create a new Student object
			Alumno stu = new Alumno();
			stu.setIdAlumno(id);
			stu.setNombre(name);
			stu.setEdad(age);
			stu.setCurso(curso);

			// Save the student object
			manager.persist(stu);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
	}

	@Override
	public void update(Long id, String name, int age, String curso) {
		// Create an EntityManager
		//EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get the Student object
			Alumno stu = manager.find(Alumno.class, id);

			// Change the values
			stu.setNombre(name);
			stu.setEdad(age);
			stu.setCurso(curso);

			// Update the student
			manager.persist(stu);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
	}

	@Override
	public void delete(Long id) {
		// Create an EntityManager
		//EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get the Student object
			Alumno stu = manager.find(Alumno.class, id);

			// Delete the student
			manager.remove(stu);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
	}

	@Override
	public ArrayList<Alumno> getAll() {
		ArrayList<Alumno> students = null;

		// Create an EntityManager
		//EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get a List of Students
			students = new ArrayList(manager.createQuery("FROM alumnos s", Alumno.class).getResultList());

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
		return students;
	}

}
