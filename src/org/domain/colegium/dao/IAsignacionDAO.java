package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.Asignacion;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;


public interface IAsignacionDAO {
	
	public List<Asignacion> obtenerAsignacionesAlumnoSubPeriodo(long idALumno , long idPeriodo);

}
