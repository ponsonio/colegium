package org.domain.colegium.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.entity.Asistencia;
import org.domain.colegium.entity.Materiales;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

@Name("materialDAO")
@AutoCreate
public class MaterialDAO implements IMaterialDAO {

	@In 
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Materiales> obtenerMaterialesXSeccionXPeriodo(long idSeccion,
			long idPeriodo) {
		ArrayList<Materiales > materiales = 
		 (ArrayList<Materiales>)entityManager
				.createQuery("select  spasc.materialeses from  SubPeriodoAcademicoSeccionCurso spasc  where spasc.seccion.idSeccion = :idSeccion ")
        		.setParameter("idSeccion", idSeccion)
        		.getResultList();
		materiales.addAll(
				 (ArrayList<Materiales>)entityManager
					.createQuery("select  pasc.materialeses from  PeriodoAcademicoSeccionCurso pasc where pasc.seccion.idSeccion = :idSeccion ")
	        		.setParameter("idSeccion", idSeccion)
	        		.getResultList()
				);
		return materiales;

	}

}
