package com.escuela.service;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import com.escuela.bean.Alumno;

@Path("/alumno")
public class AlumnoService {
	private static final long serialVersionUID = 1L;

	@GET
	@Produces("application/json")
	public Response getAlumnos() throws JSONException {
		List<Alumno> alumnos = new ArrayList<>();
		alumnos.add(new Alumno("admin"));
		alumnos.add(new Alumno("john"));
		alumnos.add(new Alumno("usuario2"));
		return Response.status(200).entity(alumnos.toString()).build();
	}
}