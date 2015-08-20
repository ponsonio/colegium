package org.domain.colegium.session.controler.alumno;

import java.util.List;

import org.domain.colegium.colegium.session.AlumnoHome;
import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.colegium.session.ResumenAlumnoHome;
import org.domain.colegium.dao.MatriculaDAO;
import org.domain.colegium.dao.PeriodoAcademicoDAO;
import org.domain.colegium.entity.Asistencia;
import org.domain.colegium.entity.MatriculaAlumno;
import org.domain.colegium.entity.PeriodoAcademico;
import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;


@Name("CAlumnoMatricula")
public class CAlumnoMatricula implements ICAlumnoMatricula {

	@Logger
	private Log log;

	@In
	StatusMessages statusMessages;
	
	@In(create = true)
	@Out
	PersonaHome personaHome;
	
	@In (create=true)
	@Out
	AlumnoHome alumnoHome;
	
	@In (create=true)
	@Out
	PeriodoAcademicoHome periodoAcademicoHome;
	
	
	@In	(create = true)
	@Out
	CAlumnoDatosPrincipales CAlumnoDatosPrincipales;
	
	@In(create = true)
	@Out
	ResumenAlumnoHome resumenAlumnoHome;
	
	@In
	PeriodoAcademicoDAO periodoAcademicoDAO;
	
	
	
	@In
	MatriculaDAO matriculaDAO;
	
	@DataModel
	List<PeriodoAcademicoSeccionCurso>  periodoAcademicoSeccionCursosLista;
	
	public void mostrarMatriculaAlumno() {
		try{
			
			if (personaHome.isIdDefined() == false || alumnoHome.isIdDefined() == false )  CAlumnoDatosPrincipales.inicializar();
			periodoAcademicoSeccionCursosLista 
			=   matriculaDAO.obtenerCursosMatriculaAlumno(alumnoHome.getInstance().getIdPersona(),
					periodoAcademicoHome.getInstance().getIdPeriodoAcademico());
	
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}

}
