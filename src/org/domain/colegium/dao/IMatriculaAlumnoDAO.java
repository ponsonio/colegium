package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.Alumno;

public interface IMatriculaAlumnoDAO {

	public List<Alumno> obtenerAlumnosSeccion(long idPeriodoAcademicoSeccion);
	
}
