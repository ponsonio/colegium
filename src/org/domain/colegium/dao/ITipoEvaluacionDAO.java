package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.TipoEvaluacion;

public interface ITipoEvaluacionDAO {
	
	public List<TipoEvaluacion> obtenerTipoEvaluacionXColegio(long idColegio);

}
