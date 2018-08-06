package com.escuela.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.escuela.dao.AlumnoDAO;
import com.escuela.dao.impl.AlumnoDAOHibernate;
import com.escuela.jpa.Alumno;

@Path("/escuela")
public class EscuelaService {

	@GET
	@Path("alumnos")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAlumnos() {
		try {
			AlumnoDAO dao = new AlumnoDAOHibernate();
			GenericEntity<List<Alumno>> genericType = new GenericEntity<List<Alumno>>(dao.getAll()) {};

			return Response.ok(genericType).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
}
