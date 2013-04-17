package org.domain.colegium.dao;

import java.util.List;


import javax.persistence.EntityManager;

import org.domain.colegium.entity.Asistencia;
import org.domain.colegium.entity.Curso;
import org.domain.colegium.entity.MatriculaAlumno;
import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;


@Name("matriculaDAO")
@AutoCreate
public class MatriculaDAO implements IMatriculaDAO {

	@In 
	private EntityManager entityManager;
	
	@Logger
	private Log log;

	
	@SuppressWarnings("unchecked")
	public List<PeriodoAcademicoSeccionCurso> obtenerCursosMatriculaAlumno(long idPersona,long idPeriodoAcademico){		
		return (List<PeriodoAcademicoSeccionCurso> )entityManager.createQuery(
				"select  distinct pasc " +
				"from MatriculaAlumno m , PeriodoAcademicoSeccion pac , PeriodoAcademicoSeccionCurso pasc ,  Curso c " +
				"where c.idCurso = pasc.curso.idCurso " +
				"and pasc.periodoAcademicoSeccion = m.periodoAcademicoSeccion " +
				"and m.alumno.idPersona = :idPersona " +
				"and m.periodoAcademicoSeccion.periodoAcademico.idPeriodoAcademico = :idPeriodoAcademico ")
        		.setParameter("idPersona", idPersona)
				.setParameter("idPeriodoAcademico", idPeriodoAcademico)
				.getResultList();
	}

}
