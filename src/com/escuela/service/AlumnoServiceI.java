package com.escuela.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/alumno")
public interface AlumnoServiceI {

	@GET
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAlumnos();
	
}