package com.escuela.service;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import com.escuela.bean.AlumnoDTO;

public class AlumnoServiceImpl implements AlumnoServiceI {

	@Override
	public Response getAlumnos() {
		List<AlumnoDTO> alumnos = new ArrayList<AlumnoDTO>();
		return Response.status(200).entity(alumnos.toString()).build();
	}
}
