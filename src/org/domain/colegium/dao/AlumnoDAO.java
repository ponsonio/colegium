package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.colegium.session.AlumnoList;
import org.domain.colegium.entity.Alumno;
import org.domain.colegium.entity.ResumenAlumno;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;


@Name("alumnoDAO")
@AutoCreate
public class AlumnoDAO implements IAlumnoDAO {
	
	public AlumnoDAO (){}
	
	
	@In 
	private EntityManager entityManager;
	
	@Logger private Log log;
	
	@SuppressWarnings("unchecked")
	public List<Alumno> obtenerDependientesPersona(long idpersona){
		return (List<Alumno>)entityManager.createQuery("select ap.alumnos from Apoderado ap where ap.idPersona = :idpersona")
        		.setParameter("idpersona", idpersona).getResultList();
	}
	
	
	public ResumenAlumno obtenerResumenPeriodo(long idPersona, long idPeriodo){
		//log.info("idPersona:"+idPersona);
		//log.info("idPeriodo:"+idPeriodo);
		return (ResumenAlumno)entityManager.createQuery("select r from ResumenAlumno r where r.alumno.idPersona = :idPersona  and r.periodoAcademico.idPeriodoAcademico = :idPeriodo")
        		.setParameter("idPersona", idPersona).
        		setParameter("idPeriodo", idPeriodo).
        		getSingleResult();
		
	}

	public Alumno obtenerAlumnoXid(long idPersona){
		return (Alumno)entityManager.createQuery(" select a from Alumno a where a.idPersona = :idPersona ")
        		.setParameter("idPersona", idPersona).
        		getSingleResult();
	}
	
}
