package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;
import org.domain.colegium.entity.RepositorioArchivos;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;


@Name("repositorioArchivosDAO")
@AutoCreate
public class RepositorioArchivosDAO implements IRepositorioArchivosDAO {

	public RepositorioArchivosDAO(){		
	}
	
	@In 
	private EntityManager entityManager;
	
	@Logger
	private Log log;
	
	/*
	 * Devuelve el repositorio por colegio
	 * @see org.domain.colegium.dao.IRepositorioArchivosDAO#obtenerRepositorioArchivosXColegio(long)
	 */
	public RepositorioArchivos obtenerRepositorioArchivosXColegio(long idColegio) {
		return (RepositorioArchivos)entityManager.createQuery(
				" select r from RepositorioArchivos r where r.colegio.idColegio  = :idColegio ")
        		.setParameter("idColegio", idColegio)
				.getSingleResult();
	}

}
