package org.domain.colegium.session.controler.alumno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;

import org.domain.colegium.colegium.session.AlumnoHome;
import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.colegium.session.ResumenAlumnoHome;
import org.domain.colegium.colegium.session.SubPeriodoAcademicoHome;
import org.domain.colegium.dao.AlumnoDAO;
import org.domain.colegium.dao.PeriodoAcademicoDAO;
import org.domain.colegium.dao.PersonaDAO;
import org.domain.colegium.entity.Persona;
import org.domain.colegium.entity.PersonaMedioContacto;
import org.jboss.beans.metadata.api.annotations.Create;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import javax.ejb.Remove;

@Name("CAlumnoDatosPrincipales")
@Scope(ScopeType.SESSION)
//@Stateful
@AutoCreate
public class CAlumnoDatosPrincipales implements ICAlumnoDatosPrincipales ,  Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@In
	Credentials credentials;

	@Logger
	private Log log;

	@In
	private PersonaDAO personaDAO;
	
	@In
	private PeriodoAcademicoDAO periodoAcademicoDAO;
	
	@In
	private AlumnoDAO alumnoDAO;

	
	@In
	StatusMessages statusMessages;

	@In(create=true)
	@Out
	PersonaHome personaHome;
	
	@In(create=true)
	@Out
	AlumnoHome alumnoHome;
	
	
	@In(create=true)
	@Out
	ResumenAlumnoHome resumenAlumnoHome;
	
	@In(create=true)
	@Out
	SubPeriodoAcademicoHome subPeriodoAcademicoHome;

	@In(create=true)
	@Out
	PeriodoAcademicoHome  periodoAcademicoHome;
	
	
	@DataModel
	private List<PersonaMedioContacto> mediosContactoLista;

	

	
	//@Create	
	public void inicializar(){		
			log.info("personaHome.getInstance() == null:"+personaHome.getInstance() == null);
			if ( personaHome.getInstance().getIdPersona() == 0 ) {
				Persona persona = personaDAO.obtenerPersonaXUsuario(credentials.getUsername());
				//personaHome = new PersonaHome();
				personaHome.setInstance(persona);
				alumnoHome.setInstance(personaHome.getInstance().getAlumno());
				periodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerPeriodoAcademicoEnCurso(alumnoHome.getInstance().getColegio().getIdColegio()));
				subPeriodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerSubPeriodoAcademicoEnCurso(alumnoHome.getInstance().getColegio().getIdColegio()));
				resumenAlumnoHome.setInstance(alumnoDAO.obtenerResumenPeriodo(alumnoHome.getInstance().getIdPersona(), periodoAcademicoHome.getInstance().getIdPeriodoAcademico())) ;
				log.info("Inicializando Datos:"+personaHome.getInstance().getIdPersona());
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

}
