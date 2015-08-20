package org.domain.colegium.session.controler.docente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.portlet.StateAwareResponse;
import javax.xml.namespace.QName;

import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.PeriodoAcademicoSeccionCursoHome;
import org.domain.colegium.colegium.session.PeriodoAcademicoSeccionHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.colegium.session.SubPeriodoAcademicoHome;
import org.domain.colegium.colegium.session.TipoEvaluacionHome;
import org.domain.colegium.dao.DocenteDAO;
import org.domain.colegium.dao.PeriodoAcademicoDAO;
import org.domain.colegium.dao.PeriodoAcademicoSeccionCursoDAO;
import org.domain.colegium.dao.PersonaDAO;
import org.domain.colegium.dao.TipoEvaluacionDAO;
import org.domain.colegium.entity.PeriodoAcademicoSeccion;
import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;
import org.domain.colegium.entity.Persona;
import org.domain.colegium.entity.PersonaMedioContacto;
import org.domain.colegium.entity.Seccion;
import org.domain.colegium.entity.TipoEvaluacion;
import org.domain.colegium.session.controler.apoderado.DependienteSelecionadoEvent;
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
import org.jboss.seam.security.Credentials;


@Name("CDocenteDatosPrincipales")
@Scope(ScopeType.SESSION)
@PortletScope(PortletScope.ScopeType.APPLICATION_SCOPE)
@AutoCreate
public class CDocenteDatosPrincipales implements ICDocenteDatosPrincipales, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@In
	Credentials credentials;

	@Logger
	private Log log;
	
	@In
	StatusMessages statusMessages;
	
	@In(create=true)
	@Out
	PersonaHome personaHome;
	
	@In(create=true)
	@Out
	SubPeriodoAcademicoHome subPeriodoAcademicoHome;

	@In(create=true)
	@Out	PeriodoAcademicoHome  periodoAcademicoHome;
	
	@In(create=true)
	@Out
	PeriodoAcademicoSeccionCursoHome  periodoAcademicoSeccionCursoHome;

	@In(create=true)
	@Out
	TipoEvaluacionHome  tipoEvaluacionHome;
	
	
	
	@DataModel
	private List<PersonaMedioContacto> mediosContactoLista;
	
	@DataModel 
	private List<PeriodoAcademicoSeccion> periodoAcademicoSeccionsTutor;
	
	@DataModel 
	private List<PeriodoAcademicoSeccionCurso> periodoAcademicoSeccionCursos;
	
	@DataModel 
	private List<PeriodoAcademicoSeccionCurso> periodoAcademicoSeccionCursosSelect;
	
	@DataModel
	private List<TipoEvaluacion> tipoEvaluacionSelect;
	
	
	@In
	private PersonaDAO personaDAO;
	
	@In
	private PeriodoAcademicoDAO periodoAcademicoDAO;
	
	@In
	private  PeriodoAcademicoSeccionCursoDAO periodoAcademicoSeccionCursoDAO ;
	
	@In
	private DocenteDAO docenteDAO;
	
	@In
	private TipoEvaluacionDAO tipoEvaluacionDAO;
	

	public void inicializar() {
		try{			
			if ( personaHome.getInstance().getIdPersona() == 0 ) {
					Persona persona = personaDAO.obtenerPersonaXUsuario(credentials.getUsername());
					personaHome.setInstance(persona);
					periodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerPeriodoAcademicoEnCurso( personaHome.getInstance().getDocente().getColegio().getIdColegio() ));
					subPeriodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerSubPeriodoAcademicoEnCurso( personaHome.getInstance().getDocente().getColegio().getIdColegio() ));
					periodoAcademicoSeccionCursos = periodoAcademicoSeccionCursoDAO.obtenerSeccionesCursoPeriodoDocente(periodoAcademicoHome.getInstance().getIdPeriodoAcademico(),
											personaHome.getInstance().getIdPersona());
					
					tipoEvaluacionSelect =  tipoEvaluacionDAO.obtenerTipoEvaluacionXColegio(persona.getDocente().getColegio().getIdColegio());
					
				}
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}		


	}

	public void mostrarDatosPrincipales() {
		try{
			this.inicializar();
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}

	public void mostrarMedioContacto() {
		try{
			this.inicializar();
			mediosContactoLista = new ArrayList<PersonaMedioContacto>();
			mediosContactoLista.addAll(personaHome.getInstance().getPersonaMedioContactos());
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}
	
	public void mostrarSeccionesTutor() {
		try{
			this.inicializar();
			periodoAcademicoSeccionsTutor = docenteDAO.seccionesTutor(personaHome.getInstance().getDocente().getIdPersona()
					,periodoAcademicoHome.getInstance().getIdPeriodoAcademico()) ;
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}
	
	public void mostrarCursosLectivos() {
		try{
			this.inicializar();
			/**
			periodoAcademicoSeccionCursos = docenteDAO.seccionesCursoLectivas(personaHome.getInstance().getDocente().getIdPersona()
					,periodoAcademicoHome.getInstance().getIdPeriodoAcademico()) ;
					**/
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}
	
	public void mostrarSeccionesPeriodoCurso(){
		try{
			this.inicializar();
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}		
	}
	
	public void seleccionarSeccion(){
			try{
				
				SeccionSelecionadaEvent seccionSelecionadaEvent = new SeccionSelecionadaEvent(periodoAcademicoSeccionCursoHome.getInstance().getIdPeriodoAcademicoSeccionCurso());
				Object response = FacesContext.getCurrentInstance().getExternalContext().getResponse();
				
			      if (response instanceof StateAwareResponse) {
				    StateAwareResponse stateResponse = (StateAwareResponse) response;
				    QName qname = new QName("http://jboss.com" , "SeccionSelecionadaEvent");
				    stateResponse.setEvent(qname, seccionSelecionadaEvent);
			       //stateResponse.setRenderParameter("hotelName",selectedHotel.getName());
			    }
			   log.info("Seccion Curso Selecionada:"+ periodoAcademicoSeccionCursoHome.getInstance().getIdPeriodoAcademicoSeccionCurso());
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}
	
	public void seleccionarEvaluacionSeccion(){
		try{
			log.info("Aca hago algo!");
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}

}
