package org.domain.colegium.dao;

import java.util.List;

import javax.ejb.Local;

import org.domain.colegium.entity.ReciboPension;

@Local
public interface IReciboPensionDAO {
	
	public List<ReciboPension> buscarRecibosPendientesDependientes(long idPersona);
	
	public List<ReciboPension> buscarRecibosDependientes(long idPersona);

	public List<ReciboPension> buscarRecibosPendientesAlumno(long idAlumno);
	
	public List<ReciboPension> buscarRecibosAlumno(long idAlumno);

}
