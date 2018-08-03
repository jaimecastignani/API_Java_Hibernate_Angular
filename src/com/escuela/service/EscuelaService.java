package com.escuela.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.escuela.dao.AlumnoDAO;
import com.escuela.dao.impl.AlumnoDAOHibernate;

@Path("/escuela")
public class EscuelaService {

	@GET
	@Path("alumnos")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAlumnos() {
		AlumnoDAO dao = new AlumnoDAOHibernate();
		return Response.status(200).entity(dao.getAll().toString()).build();
	}
}
