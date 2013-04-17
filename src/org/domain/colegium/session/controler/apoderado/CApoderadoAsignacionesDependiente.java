package org.domain.colegium.session.controler.apoderado;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;

import org.domain.colegium.colegium.session.AlumnoHome;
import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.SubPeriodoAcademicoHome;
import org.domain.colegium.dao.AlumnoDAO;
import org.domain.colegium.dao.AsignacionDAO;
import org.domain.colegium.dao.PeriodoAcademicoDAO;
import org.domain.colegium.entity.Asignacion;
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


@Name("CApoderadoAsignacionesDependiente")
@Scope(ScopeType.SESSION)
@PortletScope(PortletScope.ScopeType.APPLICATION_SCOPE)
@AutoCreate
public class CApoderadoAsignacionesDependiente implements
		ICApoderadoAsignacionesDependiente ,  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@In(create=true)
	@Out
	SubPeriodoAcademicoHome subPeriodoAcademicoHome;

	@In(create=true)
	@Out
	AlumnoHome alumnoHome;
	
	@In
	AsignacionDAO asignacionDAO;
	
	@Logger
	private Log log;
	
	@In
	StatusMessages statusMessages;
	
	
	@DataModel
	List<Asignacion> asignacionLista ;
	
	@In
	private AlumnoDAO alumnoDAO;
	
	@In
	private PeriodoAcademicoDAO periodoAcademicoDAO;
	
	@In(create=true)
	@Out
	PeriodoAcademicoHome  periodoAcademicoHome;
	
	/**
	@In(create=true)
	@Out
	CApoderadoDatosPrincipales ca;
	**/
	
	public void mostrarAsignacionesDependiente() {
		try{
			
			DependienteSelecionadoEvent d = (DependienteSelecionadoEvent)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("DependienteSelecionadoEvent");
			//Obtengo información del dependiente
			if (d != null){
				alumnoHome.setInstance(alumnoDAO.obtenerAlumnoXid(d.idpersona));
				periodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerPeriodoAcademicoEnCurso(alumnoHome.getInstance().getColegio().getIdColegio()));
				subPeriodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerSubPeriodoAcademicoEnCurso(alumnoHome.getInstance().getColegio().getIdColegio()));
			}

			asignacionLista = asignacionDAO.obtenerAsignacionesAlumnoSubPeriodo(alumnoHome.getInstance().getIdPersona()
					, subPeriodoAcademicoHome.getInstance().getIdPeriodoAcademico());
								
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}

	}





}
