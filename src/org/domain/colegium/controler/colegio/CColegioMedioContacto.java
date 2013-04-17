package org.domain.colegium.controler.colegio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.domain.colegium.colegium.session.AlumnoHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.dao.ColegioDAO;
import org.domain.colegium.dao.MatriculaDAO;
import org.domain.colegium.entity.ColegioMedioContacto;
import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;
import org.domain.colegium.entity.PersonaMedioContacto;
import org.domain.colegium.session.controler.alumno.CAlumnoDatosPrincipales;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;


@Name("CColegioMedioContacto")
@Scope(ScopeType.SESSION)
//@Stateful
@AutoCreate
public class CColegioMedioContacto implements ICColegioMedioContacto , Serializable{

	/**
	 * 
	 */


	@Logger
	private Log log;

	@In
	StatusMessages statusMessages;
	
	
	@In
	ColegioDAO  colegioDAO;
	
	@DataModel
	ArrayList<ColegioMedioContacto>  colegioMedioContactos;
	
	
	public void mostrarMedioContacto() {
		try{
			colegioMedioContactos =  new ArrayList<ColegioMedioContacto>();
			colegioMedioContactos = (ArrayList<ColegioMedioContacto>) colegioDAO.obtenerListaMediosContactoColegios();
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}

	}

}
