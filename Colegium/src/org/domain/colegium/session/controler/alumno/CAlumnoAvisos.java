package org.domain.colegium.session.controler.alumno;

import java.util.List;

import org.domain.colegium.colegium.session.AlumnoHome;
import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.colegium.session.ResumenAlumnoHome;
import org.domain.colegium.colegium.session.SubPeriodoAcademicoHome;
import org.domain.colegium.dao.AlumnoAvisoDAO;
import org.domain.colegium.entity.Asistencia;
import org.domain.colegium.entity.Aviso;
import org.domain.colegium.entity.ResumenAlumno;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;

@Name("CAlumnoAvisos")
public class CAlumnoAvisos implements ICAlumnoAvisos {
	
	
	@Logger
	private Log log;

	@In
	StatusMessages statusMessages;

	
	@In(create=true)
	PersonaHome personaHome;

	@In(create=true)
	PeriodoAcademicoHome periodoAcademicoHome;
	

	@In(create=true)
	ResumenAlumnoHome resumenAlumnoHome;
	
	@In(create=true)
	SubPeriodoAcademicoHome subPeriodoAcademicoHome;
	
	@In(create=true)
	CAlumnoDatosPrincipales CAlumnoDatosPrincipales;
	
	@In(create=true)
	AlumnoAvisoDAO alumnoAvisoDAO;
	
	@DataModel
	List<Aviso>  avisoLista;
	
	
	
	public void mostrarAvisos() {
		try{
			CAlumnoDatosPrincipales.inicializar();
			avisoLista = alumnoAvisoDAO.getAvisosAlumno(resumenAlumnoHome.getInstance().getSeccion().getIdSeccion() , subPeriodoAcademicoHome.getInstance().getIdPeriodoAcademico() );
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}

}
