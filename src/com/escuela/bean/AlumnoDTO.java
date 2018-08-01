package com.escuela.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONException;
import org.json.JSONObject;

@XmlRootElement
public class AlumnoDTO {
	@XmlElement(name = "alumnoname")
	String alumnoname;

	public AlumnoDTO() {
	}

	public AlumnoDTO(String alumnoname) {
		this.alumnoname = alumnoname;
	}

	@Override
	public String toString() {
		try {
			return new JSONObject().put("alumnoname", alumnoname).toString();
		} catch (JSONException e) {
			return null;
		}
	}
}