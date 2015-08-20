package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.Alumno;
import org.domain.colegium.entity.Aviso;

public interface IAlumnoAvisoDAO {
	
	public List<Aviso> getAvisosAlumno( long idSeccion , long idPeriodoAcademico);

}
