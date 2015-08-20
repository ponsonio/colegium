package org.domain.colegium.session.controler.apoderado;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;

import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.dao.ReciboPensionDAO;
import org.domain.colegium.entity.Aviso;
import org.domain.colegium.entity.ReciboPension;
import org.jboss.portletbridge.seam.PortletScope;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;

@Name("CApoderadoRecibos")
@Scope(ScopeType.SESSION)
@PortletScope(PortletScope.ScopeType.APPLICATION_SCOPE)
@AutoCreate
public class CApoderadoRecibos implements ICApoderadoRecibos, Serializable {

	/**
	 * 
	 */
	@In(create=true)
	PersonaHome personaHome;
	
	@Logger
	private Log log;

	@In
	StatusMessages statusMessages;
	
	@In
	ReciboPensionDAO reciboPensionDAO; 

	@DataModel
	List<ReciboPension>  reciboList;
	
	private static final long serialVersionUID = 1L;

	public void mostrarRecibosDependientes() {
		try{
			reciboList = reciboPensionDAO.buscarRecibosPendientesDependientes(personaHome.getInstance().getIdPersona());
			
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}

	}

	
}
