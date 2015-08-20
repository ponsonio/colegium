package org.domain.colegium.session.controler.alumno;

import java.io.Serializable;
import java.util.List;

import org.domain.colegium.colegium.session.AlumnoHome;
import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.dao.AsistenciaDAO;
import org.domain.colegium.dao.PeriodoAcademicoDAO;
import org.domain.colegium.entity.Asistencia;
import org.domain.colegium.entity.PeriodoAcademico;
import org.domain.colegium.entity.Persona;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;

@Name("CAlumnoAsistecia")
public class CAlumnoAsistecia implements ICAlumnoAsistencia , Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Logger
	private Log log;

	@In
	StatusMessages statusMessages;

	@In(create = true)
	@Out
	PersonaHome personaHome;

	@In(create = true)
	@Out
	AlumnoHome alumnoHome;
	
	@In(create = true)
	@Out
	PeriodoAcademicoHome periodoAcademicoHome;
	
	@In(create = true)
	@Out
	CAlumnoDatosPrincipales CAlumnoDatosPrincipales;
	
	@DataModel
	List<Asistencia>  asistenciasDependienteList;
	
	@In(create = true)
	@Out
	AsistenciaDAO asistenciaDAO;
	
	@In(create = true)
	@Out
	PeriodoAcademicoDAO periodoAcademicoDAO;
	
	public void mostrarAsistenciaAlumnoSubPeriodo() {
		try{
			
			if (personaHome.isIdDefined() == false || alumnoHome.isIdDefined() == false )  CAlumnoDatosPrincipales.inicializar();
			PeriodoAcademico subPeriodoAcademico =  periodoAcademicoDAO.obtenerSubPeriodoAcademicoEnCurso(alumnoHome.getInstance().getColegio().getIdColegio());
			asistenciasDependienteList =   asistenciaDAO.obtenerAsistenciaAlumnoSubPeriodo(alumnoHome.getInstance().getIdPersona(), subPeriodoAcademico.getIdPeriodoAcademico());

		
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}

	public void mostrarAsistenciaAlumnPeriodo() {
		// TODO Auto-generated method stub

	}

}
