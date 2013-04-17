package org.domain.colegium.dao;

import javax.ejb.Local;

import org.domain.colegium.colegium.session.PersonaList;
import org.domain.colegium.entity.Persona;

@Local
public interface IPersonaDAO {	
	
	public Persona obtenerPersonaXUsuario(String user);	
	

}
