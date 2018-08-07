package com.escuela.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAlumnos() {
		try {
			AlumnoDAO dao = new AlumnoDAOHibernate();
			return Response.ok(new GenericEntity<List<Alumno>>(dao.getAll()) {
			}).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("find")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@QueryParam("idAlumno") Long idAlumno) {
		try {
			AlumnoDAO dao = new AlumnoDAOHibernate();
			return Response.ok(dao.findById(idAlumno)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@PUT
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAlumno(Alumno alumno) {
		try {
			AlumnoDAO dao = new AlumnoDAOHibernate();
			dao.create(alumno);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAlumno(Alumno alumno) {
		try {
			AlumnoDAO dao = new AlumnoDAOHibernate();
			dao.update(alumno);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteAlumno(@QueryParam("idAlumno") Long idAlumno) {
		try {
			AlumnoDAO dao = new AlumnoDAOHibernate();
			dao.delete(idAlumno);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
}
