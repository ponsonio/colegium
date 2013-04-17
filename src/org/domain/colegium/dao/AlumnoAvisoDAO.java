package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.entity.Alumno;
import org.domain.colegium.entity.Asistencia;
import org.domain.colegium.entity.Aviso;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

@Name("alumnoAvisoDAO")
@AutoCreate
public class AlumnoAvisoDAO implements IAlumnoAvisoDAO {
	
	
	@In 
	private EntityManager entityManager;
	
	static String general = "1";
	
	
	@SuppressWarnings("unchecked")
	public List<Aviso> getAvisosAlumno(long idSeccion , long idSubPeriodoAcademico ) {
		
		return (List<Aviso>)entityManager.createQuery(
				" select aviso from Aviso aviso	where aviso.id in " +
				"(select a.id from Aviso a where  a.general = :general and a.periodoAcademico.idPeriodoAcademico = :idPeriodoAcademico ) " +
				" or aviso.id in " +
				"(select av.id from AvisoSeccion avisoSeccion , Aviso av where avisoSeccion.seccion.idSeccion = :idSeccion and av.idAviso = avisoSeccion.aviso.idAviso)"
				)
        		.setParameter("idSeccion", idSeccion)
        		.setParameter("idPeriodoAcademico", idSubPeriodoAcademico)
        		.setParameter("general", AlumnoAvisoDAO.general)        		
        		.getResultList();

	}

}
