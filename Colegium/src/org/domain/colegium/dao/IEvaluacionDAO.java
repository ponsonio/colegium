package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.Evaluacion;

public interface IEvaluacionDAO {

		public  List<Evaluacion> obtenerEvaluacion(long idTipoEvaluacion, long subPeriodoAcademicoSeccionCurso);

		public void crearEvaluacion(Evaluacion evaluacion);
}
