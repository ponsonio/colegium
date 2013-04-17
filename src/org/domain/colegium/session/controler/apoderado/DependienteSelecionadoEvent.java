package org.domain.colegium.session.controler.apoderado;

import javax.xml.bind.annotation.XmlRootElement;

import org.jboss.seam.annotations.Name;

@XmlRootElement
public class DependienteSelecionadoEvent implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1346937186118672537L;

	long idpersona;

	public DependienteSelecionadoEvent(){}
	
	public DependienteSelecionadoEvent(long idpersona) {
		super();
		this.idpersona = idpersona;
	}

	public long getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	
	
}
