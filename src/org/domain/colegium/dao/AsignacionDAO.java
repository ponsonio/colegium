package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.entity.Asignacion;
import org.domain.colegium.entity.Asistencia;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;



@Name("asignacionDAO")
@AutoCreate
public class AsignacionDAO implements IAsignacionDAO {
	

	@Logger
	private Log log;
	
	@In 
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Asignacion> obtenerAsignacionesAlumnoSubPeriodo(long idPersona,
			long idSubPeriodo) {
		return (List<Asignacion>)entityManager.createQuery("select a from Asignacion a , AsignacionAlumno aa " +
				"where aa.alumno.idPersona = :idPersona " +
				"and aa.asignacion.idAsignacion = a.idAsignacion " +
				"and aa.periodoAcademico.idPeriodoAcademico = :idSubPeriodo")
        		.setParameter("idPersona", idPersona)
				.setParameter("idSubPeriodo",idSubPeriodo)
        		.getResultList();
	}

}
