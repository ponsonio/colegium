package org.domain.colegium.session.controler.apoderado;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;

import org.domain.colegium.colegium.session.AlumnoHome;
import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.colegium.session.ResumenAlumnoHome;
import org.domain.colegium.dao.AlumnoDAO;
import org.domain.colegium.dao.MatriculaDAO;
import org.domain.colegium.dao.PeriodoAcademicoDAO;
import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;
import org.domain.colegium.session.controler.alumno.CAlumnoDatosPrincipales;
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

@Name("CApoderadoMatriculaDependiente")
@Scope(ScopeType.SESSION)
@PortletScope(PortletScope.ScopeType.APPLICATION_SCOPE)
@AutoCreate
public class CApoderadoMatriculaDependiente implements
		ICApoderadoMatriculaDependiente ,  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8951613631047977167L;

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
	private AlumnoDAO alumnoDAO;
	
	@In
	MatriculaDAO matriculaDAO;
	
	@DataModel
	List<PeriodoAcademicoSeccionCurso>  periodoAcademicoSeccionCursosLista;
	
	public void mostrarMatriculaDependiente() {
		try{
			
			DependienteSelecionadoEvent d = (DependienteSelecionadoEvent)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("DependienteSelecionadoEvent");
			if (d != null){
				alumnoHome.setInstance(alumnoDAO.obtenerAlumnoXid(d.idpersona));
				periodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerPeriodoAcademicoEnCurso(alumnoHome.getInstance().getColegio().getIdColegio()));
			}
		
			periodoAcademicoSeccionCursosLista 
			=   matriculaDAO.obtenerCursosMatriculaAlumno(alumnoHome.getInstance().getIdPersona(),
					periodoAcademicoHome.getInstance().getIdPeriodoAcademico());
	
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}


}
