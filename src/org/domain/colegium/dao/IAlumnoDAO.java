package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.Alumno;
import org.domain.colegium.entity.ResumenAlumno;


public interface IAlumnoDAO {
	
	public List<Alumno> obtenerDependientesPersona(long idpersona);
	
	public ResumenAlumno obtenerResumenPeriodo(long idAlumno, long idPeriodo);

}
