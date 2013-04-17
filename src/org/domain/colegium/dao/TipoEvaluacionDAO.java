package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.entity.Persona;
import org.domain.colegium.entity.TipoEvaluacion;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

@Name("tipoEvaluacionDAO")
@AutoCreate
public class TipoEvaluacionDAO implements ITipoEvaluacionDAO {
	
	@In 
	private EntityManager entityManager;
	
	//@Logger private Log log;
	
	public TipoEvaluacionDAO(){}

	/**
	 * Obtiene los tipos de evaluacion por colegio
	 * @param idColegio : Id del Colegio
	 */
	@SuppressWarnings("unchecked")
	public List<TipoEvaluacion> obtenerTipoEvaluacionXColegio(long idColegio) {
		return (List<TipoEvaluacion>)entityManager.createQuery("select te from TipoEvaluacion te where te.colegio.idColegio = :idColegio")
        		.setParameter("idColegio", idColegio).getResultList();		
	}

}
