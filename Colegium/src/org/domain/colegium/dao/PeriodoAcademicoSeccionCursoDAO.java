package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.entity.PeriodoAcademicoSeccion;
import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.ws.annotation.Documentation;

@Name("periodoAcademicoSeccionCursoDAO")
@AutoCreate
public class PeriodoAcademicoSeccionCursoDAO implements
		IPeriodoAcademicoSeccionCursoDAO {
	@In 
	private EntityManager entityManager;
	
	//@Logger private Log log;
	
	@SuppressWarnings("unchecked") 
	/**
	 * Obtiene  las secciones que enseña un docente para el perido que se enseña
	 */
	public List<PeriodoAcademicoSeccionCurso> obtenerSeccionesCursoPeriodoDocente(
			long idPeriodo, long idPersona) {
	
		return (List<PeriodoAcademicoSeccionCurso>)entityManager.createQuery("select pasc from PeriodoAcademicoSeccionCurso pasc , PeriodoAcademicoSeccion pas where pasc.periodoAcademicoSeccion.periodoAcademico.idPeriodoAcademico = :idPeriodo and pasc.docente.idPersona = :idPersona ")
        		.setParameter("idPeriodo", idPeriodo).setParameter("idPersona", idPersona).getResultList();
	}
	
	
	public  PeriodoAcademicoSeccionCurso obtenerPASCxID(long id){
		return  (PeriodoAcademicoSeccionCurso) entityManager.createQuery("select pasc from PeriodoAcademicoSeccionCurso pasc where pasc.idPeriodoAcademicoSeccionCurso = :id  ").setParameter("id", id).getSingleResult() ; 
	}

}
