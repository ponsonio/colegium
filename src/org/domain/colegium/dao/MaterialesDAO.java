package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.entity.LibretaNotas;
import org.domain.colegium.entity.Materiales;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

@Name("materialesDAO")
@AutoCreate
public class MaterialesDAO implements IMaterialesDAO {
	
	public MaterialesDAO(){}

	
	@In 
	private EntityManager entityManager;
	
	@Logger
	private Log log;
	
	public List<Materiales> obtenerMaterialesAlumnoCiclo(long idAlumno,
			long idPeriodoAcademico) {
		// TODO Auto-generated method stub
		/*return (List<Materiales>)entityManager.createQuery("select libreta from LibretaNotas libreta where libreta.alumno.idPersona = :idAlumno")
        		.setParameter("idAlumno", idAlumno).getResultList();*/
		return null;
	}
	
	
	public void crearMaterial(Materiales materiales) {
		entityManager.persist(materiales);
	}

}
