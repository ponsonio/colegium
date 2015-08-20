package org.domain.colegium.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.entity.Asistencia;
import org.domain.colegium.entity.PeriodoAcademico;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

@Name("asistenciaDAO")
@AutoCreate
public class AsistenciaDAO implements IAsistenciaDAO {
	
	static String asistio = "0";
	
	@In 
	private EntityManager entityManager;

	public List<Asistencia> obtenerAsistenciaAlumnoSubPeriodo(long idAlumno, long idSubPeriodoAcademico) {
		//return (List<Asistencia>)entityManager.createQuery("select a from Asistencia a")
		return (List<Asistencia>)entityManager.createQuery("select a from Asistencia a where a.alumno.idPersona = :idalumno and a.asistio = :asistio and a.periodoAcademico.idPeriodoAcademico = :idperiodo")
        		.setParameter("idperiodo", idSubPeriodoAcademico)
				.setParameter("asistio", this.asistio)
        		.setParameter("idalumno", idAlumno)
        		.getResultList();
		
	}
	
	
	public List<Asistencia> obtenerAsistenciaAlumnoPeriodo(long idAlumno, long idPeriodoAcademico) {
		//return (List<Asistencia>)entityManager.createQuery("select a from Asistencia a")
		return (List<Asistencia>)entityManager.createQuery("select a from Asistencia a where a.asistio = :asistio and a.alumno.idPersona = :idalumno  and a.periodoAcademicoSeccionCurso.periodoAcademicoSeccion.periodoAcademico.idPeriodoAcademico = :idperiodo")
        		.setParameter("idperiodo", idPeriodoAcademico)
				.setParameter("asistio", this.asistio)
        		.setParameter("idalumno", idAlumno)
        		.getResultList();
		
	}

	/**
	 * Crea las asistencias
	 * @param asistencias
	 */
	public void crearAsistencias(List<Asistencia> asistencias) {
		Iterator<Asistencia>  it = asistencias.iterator();
		//entityManager.getTransaction().begin();
		Asistencia asistencia ;
		while (it.hasNext()){
			asistencia = it.next();
			entityManager.persist(asistencia);
		}
	}

}
