package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.Curso;
import org.domain.colegium.entity.MatriculaAlumno;
import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;

public interface IMatriculaDAO {
	
	public List<PeriodoAcademicoSeccionCurso> obtenerCursosMatriculaAlumno(long idAlumno,long idPeriodoAcademico);

}
