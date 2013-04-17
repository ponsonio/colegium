package org.domain.colegium.session.controler.apoderado;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;

import org.domain.colegium.colegium.session.AlumnoHome;
import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.colegium.session.ResumenAlumnoHome;
import org.domain.colegium.colegium.session.SubPeriodoAcademicoHome;
import org.domain.colegium.dao.AlumnoAvisoDAO;
import org.domain.colegium.dao.AlumnoDAO;
import org.domain.colegium.dao.AsistenciaDAO;
import org.domain.colegium.dao.PeriodoAcademicoDAO;
import org.domain.colegium.entity.Aviso;
import org.jboss.portletbridge.seam.PortletScope;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;

@Name("CApoderadoAvisosDependiente")
@Scope(ScopeType.SESSION)
@PortletScope(PortletScope.ScopeType.APPLICATION_SCOPE)
@AutoCreate
public class CApoderadoAvisosDependiente implements
		ICApoderadoAvisosDependiente ,  Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */


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
	AlumnoAvisoDAO alumnoAvisoDAO;
	
	@In(create = true)
	@Out
	AsistenciaDAO asistenciaDAO;
	
	@In(create = true)
	@Out
	PeriodoAcademicoDAO periodoAcademicoDAO;
	
	@In
	private AlumnoDAO alumnoDAO;
	
	@DataModel
	List<Aviso>  avisoLista;
	
	@In(create = true)
	@Out
	AlumnoHome alumnoHome;
	
	public void mostrarAvisosDependiente() {
		try{
			DependienteSelecionadoEvent d = (DependienteSelecionadoEvent)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("DependienteSelecionadoEvent");
			if (d != null){
				alumnoHome.setInstance(alumnoDAO.obtenerAlumnoXid(d.idpersona));
				periodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerPeriodoAcademicoEnCurso(alumnoHome.getInstance().getColegio().getIdColegio()));
				subPeriodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerSubPeriodoAcademicoEnCurso(alumnoHome.getInstance().getColegio().getIdColegio()));
				resumenAlumnoHome.setInstance(alumnoDAO.obtenerResumenPeriodo(alumnoHome.getInstance().getIdPersona(), periodoAcademicoHome.getInstance().getIdPeriodoAcademico())) ;
			}

			avisoLista = alumnoAvisoDAO.getAvisosAlumno(resumenAlumnoHome.getInstance().getSeccion().getIdSeccion() , subPeriodoAcademicoHome.getInstance().getIdPeriodoAcademico() );
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}

}
