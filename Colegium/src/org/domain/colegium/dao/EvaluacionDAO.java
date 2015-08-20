package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.entity.Evaluacion;
import org.domain.colegium.entity.PeriodoAcademico;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;



@Name("evaluacionDAO")
@AutoCreate
public class EvaluacionDAO implements IEvaluacionDAO {
	
	@In 
	private EntityManager entityManager;
	
	public List<Evaluacion> obtenerEvaluacion(long idTipoEvaluacion,
			long idSubPeriodoAcademicoSeccionCurso) {
		return (List<Evaluacion>)entityManager.createQuery("select e from Evaluacion e where e.tipoEvaluacion.idTipoEvaluacion = :idTipoEvaluacion  and e.subPeriodoAcademicoSeccionCurso.idSubPeriodoAcademicoSeccionCurso = :idSubPeriodoAcademicoSeccionCurso ")
				.setParameter("idTipoEvaluacion",idTipoEvaluacion)
				.setParameter("idSubPeriodoAcademicoSeccionCurso", idSubPeriodoAcademicoSeccionCurso)
						.getResultList();
	}

	public void crearEvaluacion(Evaluacion evaluacion){
		entityManager.persist(evaluacion);
	}
	
}
