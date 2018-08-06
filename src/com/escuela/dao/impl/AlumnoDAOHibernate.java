package com.escuela.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.escuela.dao.AlumnoDAO;
import com.escuela.jpa.Alumno;

public class AlumnoDAOHibernate implements AlumnoDAO {
	// Create an EntityManagerFactory when you start the application.
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("PERSISTENCE");

	// @PersistenceContext(unitName = "PERSISTENCE")
	// private static EntityManager manager;

	@Override
	public void create(Alumno alumno) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Save the student object
			manager.persist(alumno);

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
			ENTITY_MANAGER_FACTORY.close();
		}
	}

	@Override
	public void update(Alumno alumno) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get the Student object
			Alumno stu = manager.find(Alumno.class, alumno.getIdAlumno());

			// Change the values
			stu.setNombre(alumno.getNombre());
			stu.setEdad(alumno.getEdad());
			stu.setCurso(alumno.getCurso());

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
			ENTITY_MANAGER_FACTORY.close();
		}
	}

	@Override
	public void delete(Long id) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
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
			ENTITY_MANAGER_FACTORY.close();
		}
	}

	@Override
	public List<Alumno> getAll() {
		ArrayList<Alumno> students = null;
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get a List of Students
			students = new ArrayList<Alumno>(manager.createQuery("FROM Alumno", Alumno.class).getResultList());

			// Print all the Students
			if (students != null) {
				for (Alumno student : students) {
					System.out.println(student);
				}
			}

		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// NEVER FORGET TO CLOSE THE ENTITY_MANAGER_FACTORY
			//ENTITY_MANAGER_FACTORY.close();
		}
		
		return students;
	}

}
