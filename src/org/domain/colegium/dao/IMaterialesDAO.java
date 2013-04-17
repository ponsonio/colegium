package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.Materiales;

public interface IMaterialesDAO {
	
	public List<Materiales> obtenerMaterialesAlumnoCiclo(long idAlumno, long idPeriodoAcademico);
	
	public void crearMaterial(Materiales materiales);

}
