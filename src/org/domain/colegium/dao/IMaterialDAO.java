package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.Materiales;

public interface IMaterialDAO {
	
	public List<Materiales> obtenerMaterialesXSeccionXPeriodo(long idSeccion , long idPeriodo );

}
