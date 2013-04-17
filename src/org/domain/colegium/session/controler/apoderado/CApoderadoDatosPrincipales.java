package org.domain.colegium.session.controler.apoderado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.StateAwareResponse;
import javax.xml.namespace.QName;
import javax.faces.context.FacesContext;

import org.domain.colegium.colegium.session.AlumnoHome;
import org.domain.colegium.colegium.session.AlumnoList;
import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.colegium.session.ResumenAlumnoHome;
import org.domain.colegium.colegium.session.SubPeriodoAcademicoHome;
import org.domain.colegium.dao.AlumnoDAO;
import org.domain.colegium.dao.PeriodoAcademicoDAO;
import org.domain.colegium.dao.PersonaDAO;
import org.domain.colegium.entity.Alumno;
import org.domain.colegium.entity.PeriodoAcademico;
import org.domain.colegium.entity.Persona;
import org.domain.colegium.entity.PersonaMedioContacto;
import org.domain.colegium.entity.ResumenAlumno;
import org.jboss.portletbridge.seam.PortletScope;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;


@Name("CApoderadoDatosPrincipales")
@Scope(ScopeType.SESSION)
@PortletScope(PortletScope.ScopeType.APPLICATION_SCOPE)
@AutoCreate
public class CApoderadoDatosPrincipales implements ICApoderadoDatosPrincipales ,  Serializable {

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
	
	@In
	private PeriodoAcademicoDAO periodoAcademicoDAO;
	
	@In(create=true)
	@Out
	ResumenAlumnoHome resumenAlumnoHome;
	
	
	@In(create=true)
	@Out
	PersonaHome personaHome;
	
	@In(create=true)
	@Out
	SubPeriodoAcademicoHome subPeriodoAcademicoHome;

	@In(create=true)
	@Out
	PeriodoAcademicoHome  periodoAcademicoHome;
	
	/*
	 @In(create=true)
	@Out
	AlumnoList alumnoList;*/
	
	@In
	private PersonaDAO personaDAO;

	@In
	private AlumnoDAO alumnoDAO;
	
	
	@DataModel
	private List<PersonaMedioContacto> mediosContactoLista;
	
	@DataModel
	private List<Alumno> alumnoDependientes;
	
	@DataModelSelection("alumnoDependientes")
	Alumno dependienteSelect;
	
	
	
	@In(create=true)
	@Out
	AlumnoHome alumnoHome;
	
	public void inicializar() {
		try{			
			if ( personaHome.getInstance().getIdPersona() == 0 ) {
					log.info("Inicializando variables ........");
					Persona persona = personaDAO.obtenerPersonaXUsuario(credentials.getUsername());
					personaHome.setInstance(persona);
					alumnoDependientes =  alumnoDAO.obtenerDependientesPersona(personaHome.getInstance().getIdPersona());
					Iterator<Alumno> it = alumnoDependientes.iterator();
					if (it.hasNext()){
						alumnoHome.setInstance(it.next());	//alumno por default
						log.info("alumno default: alumnoHome.getInstance().getIdPersona():"+alumnoHome.getInstance().getIdPersona());
						periodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerPeriodoAcademicoEnCurso(alumnoHome.getInstance().getColegio().getIdColegio()));
						subPeriodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerSubPeriodoAcademicoEnCurso(alumnoHome.getInstance().getColegio().getIdColegio()));
						resumenAlumnoHome.setInstance(alumnoDAO.obtenerResumenPeriodo(alumnoHome.getInstance().getIdPersona(), periodoAcademicoHome.getInstance().getIdPeriodoAcademico())) ;
					}
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
	

	public void mostrarDependientes(){
		try{
			this.inicializar();
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}		
	}
	
	public void seleccionarDependiente(){
			try{
				
				DependienteSelecionadoEvent dependienteSelecionadoEvent = new DependienteSelecionadoEvent(alumnoHome.getInstance().getIdPersona());
				Object response = FacesContext.getCurrentInstance().getExternalContext().getResponse();
				
			      if (response instanceof StateAwareResponse) {
				    StateAwareResponse stateResponse = (StateAwareResponse) response;
				    QName qname = new QName("http://jboss.com" , "DependienteSelecionadoEvent");
				    stateResponse.setEvent(qname, dependienteSelecionadoEvent);
			       //stateResponse.setRenderParameter("hotelName",selectedHotel.getName());
			    }
			   log.info("Alumno Selecionado, enviando evento idaAlum:"+ alumnoHome.getInstance().getIdPersona());
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}
	
	
	public void mostrarDependienteDatosPrincipales(){
		try{
			DependienteSelecionadoEvent d = (DependienteSelecionadoEvent)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("DependienteSelecionadoEvent");
			//Obtengo información del dependiente
			if (d != null){
				log.info("recibi evento refrescando datos dependiente id:"+d.idpersona );	
				alumnoHome.setInstance(alumnoDAO.obtenerAlumnoXid(d.idpersona));
				periodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerPeriodoAcademicoEnCurso(alumnoHome.getInstance().getColegio().getIdColegio()));
				subPeriodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerSubPeriodoAcademicoEnCurso(alumnoHome.getInstance().getColegio().getIdColegio()));
				resumenAlumnoHome.setInstance(alumnoDAO.obtenerResumenPeriodo(alumnoHome.getInstance().getIdPersona(), periodoAcademicoHome.getInstance().getIdPeriodoAcademico())) ;
			}
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}
	
	
	public void mostrarMedioContactoDependiente() {
		try{
			DependienteSelecionadoEvent d = (DependienteSelecionadoEvent)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("DependienteSelecionadoEvent");
			//this.inicializar();
			if (d != null){
				log.info("recibi evento refrescando medio contacto id:"+d.idpersona );	
				alumnoHome.setInstance(alumnoDAO.obtenerAlumnoXid(d.idpersona));
				mediosContactoLista = new ArrayList<PersonaMedioContacto>();
				mediosContactoLista.addAll(alumnoHome.getInstance().getPersona().getPersonaMedioContactos());
			}	
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}
	
}
