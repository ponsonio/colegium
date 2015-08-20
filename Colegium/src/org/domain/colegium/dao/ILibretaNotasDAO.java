package org.domain.colegium.dao;

import java.util.List;

import org.domain.colegium.entity.LibretaNotas;

public interface ILibretaNotasDAO {
	
	public LibretaNotas obtenerLibretaNotasAlumnoPeriodo(long idAlumno, long idPeriodo);
	
	public List<LibretaNotas> obtenerLibretaNotasAlumno(long idAlumno);

}
