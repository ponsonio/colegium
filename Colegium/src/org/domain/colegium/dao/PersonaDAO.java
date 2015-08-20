package org.domain.colegium.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;


import org.domain.colegium.colegium.session.PersonaList;
import org.domain.colegium.entity.Persona;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;


//@Stateless
@Name("personaDAO")
@AutoCreate
public class PersonaDAO implements IPersonaDAO{
	
	@In 
	private EntityManager entityManager;
	
	@Logger private Log log;
	   
	public PersonaDAO(){}
	
	public Persona obtenerPersonaXUsuario(String user) {
		
		return (Persona)entityManager.createQuery("select persona from Persona persona where persona.usuario= :usr")
        		.setParameter("usr", user).getSingleResult();		
		
	}
	
}
