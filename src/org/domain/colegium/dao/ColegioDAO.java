package org.domain.colegium.dao;

import java.util.List;


import javax.persistence.EntityManager;

import org.domain.colegium.entity.ColegioMedioContacto;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;


@Name("colegioDAO")
@AutoCreate 
public class ColegioDAO implements IColegioDAO {
	

	@In 
	private EntityManager entityManager;
	
	
	public ColegioDAO() {
	}
	

	@SuppressWarnings("unchecked")
	public List<ColegioMedioContacto> obtenerListaMediosContactoColegios() {
		return (List<ColegioMedioContacto> )
					entityManager.createQuery("select cmc from ColegioMedioContacto cmc ")
        		.getResultList();
	}

}
