package org.domain.colegium.dao;

import org.domain.colegium.entity.PeriodoAcademico;


public interface IPeriodoAcademicoDAO {
	
	public PeriodoAcademico obtenerPeriodoAcademicoEnCurso(long id_colegio);
	
	public PeriodoAcademico obtenerSubPeriodoAcademicoEnCurso(long id_colegio);

}
