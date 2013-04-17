package org.domain.colegium.session.controler.docente;

import javax.xml.bind.annotation.XmlRootElement;

import org.jboss.seam.annotations.Name;

@XmlRootElement
public class SeccionSelecionadaEvent implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5064217984304524909L;
	/**
	 * 
	 */
	long idseccion;

	public SeccionSelecionadaEvent(){}
	
	public SeccionSelecionadaEvent(long idSeccion) {
		super();
		this.idseccion = idSeccion;
	}

	public long getIdseccion() {
		return idseccion;
	}

	public void setIdseccion(long idseccion) {
		this.idseccion = idseccion;
	}


	
	
}
