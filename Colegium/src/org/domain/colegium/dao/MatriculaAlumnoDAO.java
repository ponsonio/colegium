package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.entity.Alumno;
import org.domain.colegium.entity.Persona;
import org.domain.colegium.entity.ReciboPension;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

@Name("matriculaAlumnoDAO")
@AutoCreate
public class MatriculaAlumnoDAO implements IMatriculaAlumnoDAO {
	
	@In 
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Alumno> obtenerAlumnosSeccion(long idPeriodoAcademicoSeccion) {
		
		return (List<Alumno>)entityManager.createQuery("select a from Alumno a  , MatriculaAlumno ma where ma.alumno = a and ma.periodoAcademicoSeccion.idPeriodoAcademicoSeccion = :idPeriodoAcademicoSeccion ) ")
        		.setParameter("idPeriodoAcademicoSeccion", idPeriodoAcademicoSeccion).getResultList();
		
	}

}
