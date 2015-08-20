package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.Asistencia;

public interface IAsistenciaDAO {
	
	public List<Asistencia> obtenerAsistenciaAlumnoSubPeriodo(long idAlumno, long idSubPeriodoAcademico) ;
	
	public List<Asistencia> obtenerAsistenciaAlumnoPeriodo(long idAlumno, long idPeriodoAcademico);
	

}
