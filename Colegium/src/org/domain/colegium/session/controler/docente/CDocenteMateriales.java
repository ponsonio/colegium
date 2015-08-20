package org.domain.colegium.session.controler.docente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.colegium.session.SubPeriodoAcademicoHome;
import org.domain.colegium.dao.DocenteDAO;
import org.domain.colegium.dao.MaterialesDAO;
import org.domain.colegium.dao.PeriodoAcademicoDAO;
import org.domain.colegium.dao.PersonaDAO;
import org.domain.colegium.dao.RepositorioArchivosDAO;
import org.domain.colegium.entity.Materiales;
import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;
import org.domain.colegium.entity.Persona;
import org.domain.colegium.entity.RepositorioArchivos;
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


@Name("CDocenteMateriales")
@Scope(ScopeType.SESSION)
@PortletScope(PortletScope.ScopeType.APPLICATION_SCOPE)
@AutoCreate
public class CDocenteMateriales implements ICDocenteMateriales , Serializable {

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
	@Out
	PeriodoAcademicoHome  periodoAcademicoHome;
	
	@DataModel private List<PeriodoAcademicoSeccionCurso> periodoAcademicoSeccionCursoList;
	
	
	@DataModelSelection private PeriodoAcademicoSeccionCurso  periodoAcademicoSeccionCursoSelect ;
	
	
	@In
	private DocenteDAO docenteDAO;
	
	
	@In
	private PersonaDAO personaDAO;
	
	@In
	private MaterialesDAO materialesDAO;
	
	@In
	private RepositorioArchivosDAO repositorioArchivosDAO;
	
	@In
	private PeriodoAcademicoDAO periodoAcademicoDAO;

	
	@In(create=true)
	@Out
	Materiales materiales;
	
	public void inicializar() {
		try{			
			if ( personaHome.getInstance().getIdPersona() == 0 ) {
					Persona persona = personaDAO.obtenerPersonaXUsuario(credentials.getUsername());
					personaHome.setInstance(persona);
					periodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerPeriodoAcademicoEnCurso( personaHome.getInstance().getDocente().getColegio().getIdColegio() ));
					subPeriodoAcademicoHome.setInstance(periodoAcademicoDAO.obtenerSubPeriodoAcademicoEnCurso( personaHome.getInstance().getDocente().getColegio().getIdColegio() ));
				}
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}		


	}
	
	public void verMateriales() {
		// TODO Auto-generated method stub

	}

	public void eliminarMaterial() {
		// TODO Auto-generated method stub

	}


	public void publicarMaterial() {
		log.debug("aca toy");
		this.inicializar();
		try{
			RepositorioArchivos rep = repositorioArchivosDAO.obtenerRepositorioArchivosXColegio(personaHome.getInstance().getDocente().getColegio().getIdColegio());
					materiales.setRepositorioArchivos(rep);
					materialesDAO.crearMaterial(materiales);

		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}		
	}
	
	
	public void nuevoMaterial(){
		log.debug("nuevo material");
		//materiales = new Materiales();
		this.inicializar();
		periodoAcademicoSeccionCursoList = docenteDAO.seccionesCursoLectivas(personaHome.getInstance().getDocente().getIdPersona()
				,periodoAcademicoHome.getInstance().getIdPeriodoAcademico()) ;
		
	}

}
