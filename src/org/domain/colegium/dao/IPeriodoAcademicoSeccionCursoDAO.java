package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;

public interface IPeriodoAcademicoSeccionCursoDAO {

	public List<PeriodoAcademicoSeccionCurso> obtenerSeccionesCursoPeriodoDocente(long idPeriodo, long idDocente);
	
}
