package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.PeriodoAcademicoSeccion;
import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;

public interface IDocenteDAO {

	public List<PeriodoAcademicoSeccion> seccionesTutor(long idDocente, long idPeriodo);
	
	public List<PeriodoAcademicoSeccionCurso> seccionesCursoLectivas(long idDocente, long idPeriodo);
	
}
