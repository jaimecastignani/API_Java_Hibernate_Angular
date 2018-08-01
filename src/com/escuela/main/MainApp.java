package com.escuela.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.escuela.jpa.Alumno;

/**
 * @author
 */
public class MainApp {
	// Create an EntityManagerFactory when you start the application.
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("PERSISTENCE");

	// @PersistenceContext(unitName = "PERSISTENCE")
	// private static EntityManager manager;

	public static void main(String[] args) {

		ArrayList<Alumno> students = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Create a new Student object
			Alumno stu = new Alumno();
			// stu.setIdAlumno(id);
			stu.setNombre("Test");
			stu.setEdad(10);
			stu.setCurso("Primero");

			// Save the student object
			manager.persist(stu);

			// Commit the transaction
			transaction.commit();

			// Get a List of Students
			students = new ArrayList(manager.createQuery("FROM Alumno", Alumno.class).getResultList());

			// Print all the Students
			if (students != null) {
				for (Object student : students) {
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
			ENTITY_MANAGER_FACTORY.close();
		}

	}

}
