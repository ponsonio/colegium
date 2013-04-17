package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;


import org.domain.colegium.entity.LibretaNotas;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

@Name("libretaNotasDAO")
@AutoCreate
public class LibretaNotasDAO implements ILibretaNotasDAO {

	@In 
	private EntityManager entityManager;
	
	public LibretaNotas obtenerLibretaNotasAlumnoPeriodo(long idAlumno, long idPeriodo){
		return (LibretaNotas)entityManager.createQuery("select libreta from LibretaNotas libreta where libreta.alumno.idPersona = :idAlumno and libreta.periodoAcademico.idPeriodoAcademico = :idPeriodo")
        		.setParameter("idAlumno", idAlumno)
        		.setParameter("idPeriodo", idPeriodo).getSingleResult();		
	}
	
	@SuppressWarnings("unchecked")
	public List<LibretaNotas> obtenerLibretaNotasAlumno(long idAlumno){
		return (List<LibretaNotas>)entityManager.createQuery("select libreta from LibretaNotas libreta where libreta.alumno.idPersona = :idAlumno")
        		.setParameter("idAlumno", idAlumno).getResultList();	
	};

}
