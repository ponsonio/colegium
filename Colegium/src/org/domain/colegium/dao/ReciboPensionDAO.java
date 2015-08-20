/**
 * 
 */
package org.domain.colegium.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.domain.colegium.entity.ReciboPension;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

/**
 * @author jcabrera
 *
 */
@Name("reciboPensionDAO")
@AutoCreate
public class ReciboPensionDAO implements IReciboPensionDAO {

	
	@In 
	private EntityManager entityManager;
	
   
	
	/* *
	 * Busca los recibos pendientes de los dependientes de la persona correspondiente
	 * (non-Javadoc)
	 * @see org.domain.colegium.dao.IReciboPensionDAO#buscarPagosPendientesDependientes(long)
	 */


	public List<ReciboPension> buscarRecibosPendientesDependientes(long idPersona) {
		return (List<ReciboPension>)entityManager.createQuery("	select r from ReciboPension r where r.fechaPago is null and r.alumno.idPersona	in ( select a.idPersona from  Apoderado ap inner join ap.alumnos a 	where ap.idPersona = :id ) ")
        		.setParameter("id", idPersona).getResultList();
	}

	
	/* *
	 * Busca los recibos de los dependientes de la persona 
	 * (non-Javadoc)
	 * @see org.domain.colegium.dao.IReciboPensionDAO#buscarPagosPendientesDependientes(long)
	 */


	public List<ReciboPension> buscarRecibosDependientes(long idPersona) {
		return (List<ReciboPension>)entityManager.createQuery("	select r from ReciboPension r where r.alumno.idPersona	in ( select a.idPersona from  Apoderado ap inner join ap.alumnos a 	where ap.idPersona = :id ) ")
        		.setParameter("id", idPersona).getResultList();
	}

	
	/* *
	 * Busca los recibos de un alumno que esten pendientes
	 * (non-Javadoc)
	 * * @see org.domain.colegium.dao.IReciboPensionDAO#buscarPagosPendientesAlumno(long)
	 */

	public List<ReciboPension> buscarRecibosAlumno(	long idAlumno) {
		return (List<ReciboPension>)entityManager.createQuery("select r from ReciboPension r where   r.alumno.idPersona = :id")
        		.setParameter("id", idAlumno).getResultList();
		}


	/* *
	 * Busca los recibos de un alumno que esten pendientes
	 * (non-Javadoc)
	 * * @see org.domain.colegium.dao.IReciboPensionDAO#buscarPagosPendientesAlumno(long)
	 */

	public List<ReciboPension> buscarRecibosPendientesAlumno(	long idAlumno) {
		return (List<ReciboPension>)entityManager.createQuery("select r from ReciboPension r where r.fechaPago is null and r.alumno.idPersona = :id")
        		.setParameter("id", idAlumno).getResultList();
		}




}
