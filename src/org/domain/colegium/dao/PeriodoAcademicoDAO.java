package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.domain.colegium.entity.PeriodoAcademico;
import org.domain.colegium.entity.ReciboPension;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;


@Name("periodoAcademicoDAO")
@AutoCreate
public class PeriodoAcademicoDAO implements IPeriodoAcademicoDAO {

	@In 
	private EntityManager entityManager;
	
	/**
	 * Cambiar!!!
	 * */
	public PeriodoAcademico obtenerPeriodoAcademicoEnCurso(long id_colegio) {
		return (PeriodoAcademico)entityManager.createQuery("select periodoAcademico from PeriodoAcademico periodoAcademico where periodoAcademico.idPeriodoAcademico = 2 ")
		//return (PeriodoAcademico)entityManager.createQuery("select periodoAcademico from PeriodoAcademico periodoAcademico where periodoAcademico.idPeriodoAcademico = 1  and periodoAcademico.periodoAcademico = null and periodoAcademico.colegio.idColegio = :id ) ")
        		//.setParameter("id", id_colegio)
				.getSingleResult();
	}

	
	/**
	 * Cambiar!!!
	 * */
	public PeriodoAcademico obtenerSubPeriodoAcademicoEnCurso(long id_colegio) {
		return (PeriodoAcademico)entityManager.createQuery("select periodoAcademico from PeriodoAcademico periodoAcademico where  periodoAcademico.idPeriodoAcademico = 3 ")
		//return (PeriodoAcademico)entityManager.createQuery("select periodoAcademico from PeriodoAcademico periodoAcademico where  periodoAcademico.idPeriodoAcademico = 3  and periodoAcademico.colegio.idColegio = = :id ) ")
				//.setParameter("id", id_colegio)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<PeriodoAcademico>  obtenerSubPeriodosAcademicos(long id_colegio, long id_periodo_padre) {
		return (List<PeriodoAcademico>)entityManager.createQuery("select periodoAcademico from PeriodoAcademico periodoAcademico where periodoAcademico.periodoAcademico.idPeriodoAcademico = :id order by periodoAcademico.fechaFin ")
		//return (PeriodoAcademico)entityManager.createQuery("select periodoAcademico from PeriodoAcademico periodoAcademico where  periodoAcademico.idPeriodoAcademico = 3  and periodoAcademico.colegio.idColegio = = :id ) ")
				.setParameter("id",id_periodo_padre)
				.getResultList();
	}

	
}