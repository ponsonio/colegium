package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.entity.Alumno;
import org.domain.colegium.entity.PeriodoAcademicoSeccion;
import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;
import org.domain.colegium.entity.Persona;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

@Name("docenteDAO")
@AutoCreate 
public class DocenteDAO implements IDocenteDAO {

	@In 
	private EntityManager entityManager;
	
	@Logger private Log log;
	

	public DocenteDAO() {
	}

	@SuppressWarnings("unchecked") 
	public List<PeriodoAcademicoSeccion> seccionesTutor(long idDocente, long idPeriodo) {
		// select pas from PeriodoAcademicoSeccion pas 	where pas.idDocenteTutor=21
		return (List<PeriodoAcademicoSeccion>)entityManager.createQuery("select pas from PeriodoAcademicoSeccion pas where pas.idDocenteTutor= :idDocente and pas.periodoAcademico.idPeriodoAcademico = :idPeriodo")
        		.setParameter("idDocente", idDocente).setParameter("idPeriodo", idPeriodo).getResultList();
	
	}
	
	@SuppressWarnings("unchecked")
	public List<PeriodoAcademicoSeccionCurso> seccionesCursoLectivas(long idDocente, long idPeriodo) {
		return (List<PeriodoAcademicoSeccionCurso>)entityManager.createQuery("select pasc from PeriodoAcademicoSeccionCurso pasc where pasc.docente.idPersona = :idDocente and pasc.periodoAcademicoSeccion.periodoAcademico.idPeriodoAcademico = :idPeriodo")
        		.setParameter("idDocente", idDocente).setParameter("idPeriodo", idPeriodo).getResultList();
	}

}
