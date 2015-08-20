package org.domain.colegium.session.controler.alumno;

import java.io.Serializable;
import java.util.List;

import org.domain.colegium.colegium.session.AlumnoHome;
import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.colegium.session.ResumenAlumnoHome;
import org.domain.colegium.colegium.session.SubPeriodoAcademicoHome;
import org.domain.colegium.dao.AsignacionDAO;
import org.domain.colegium.dao.MaterialDAO;
import org.domain.colegium.dao.PeriodoAcademicoDAO;
import org.domain.colegium.entity.Asignacion;
import org.domain.colegium.entity.Materiales;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;

@Name("CAlumnoAsignaciones")
public class CAlumnoAsignaciones implements ICAlumnoAsignaciones , Serializable {

	private static final long serialVersionUID = 1L;
	
	@Logger
	private Log log;

	@In
	StatusMessages statusMessages;
	
	@In(create=true)
	PersonaHome personaHome;
	
	@In(create=true)
	AlumnoHome alumnoHome;
	
	@In(create=true)
	ResumenAlumnoHome resumenAlumnoHome;
	
	@In(create=true)
	SubPeriodoAcademicoHome subPeriodoAcademicoHome ;
	
	@DataModel
	List<Asignacion> asignacionLista ;
	
	@In
	CAlumnoDatosPrincipales CAlumnoDatosPrincipales;
	
	@In
	AsignacionDAO asignacionDAO;

	@In
	private PeriodoAcademicoDAO periodoAcademicoDAO;
	
	public void mostrarAsignaciones() {
		try{
			CAlumnoDatosPrincipales.inicializar();
			//log.info("personaHome.getInstance().getIdPersona():"+personaHome.getInstance().getIdPersona());
			//log.info("alumnoHome.getInstance().getIdPersona():"+alumnoHome.getInstance().getIdPersona());
			
			asignacionLista = asignacionDAO.obtenerAsignacionesAlumnoSubPeriodo(alumnoHome.getInstance().getIdPersona()
					, subPeriodoAcademicoHome.getInstance().getIdPeriodoAcademico());
			//asignacionLista = asignacionDAO.obtenerAsignacionesAlumnoSubPeriodo(1, 3);
			log.info("size:"+asignacionLista.size());
					
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}

	}

}
