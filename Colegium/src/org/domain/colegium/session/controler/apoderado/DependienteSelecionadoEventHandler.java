package org.domain.colegium.session.controler.apoderado;

import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.In;
import org.jboss.seam.log.Log;
import org.jboss.seam.ScopeType;
import static org.jboss.seam.ScopeType.SESSION;
import org.jboss.portletbridge.seam.PortletScope;

import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;
import javax.portlet.Event;
import javax.faces.context.FacesContext;


public class DependienteSelecionadoEventHandler  implements BridgeEventHandler
{

  	//@Logger
	//private Log log;
  	
  	public EventNavigationResult handleEvent(FacesContext context, Event event)
	   {
	      context.getExternalContext().getSessionMap().put(event.getName(),event.getValue());
	      return new EventNavigationResult(null,"/apoderado/apoderadoDependienteDatosPrincipales.xhtml");
	      //log.info("Recibi el evento");
  		  //return null;
	   }

	}
