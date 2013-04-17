package org.domain.colegium.session.controler.docente;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.SubPeriodoAcademicoHome;
import org.domain.colegium.dao.MatriculaAlumnoDAO;
import org.domain.colegium.dao.PeriodoAcademicoSeccionCursoDAO;
import org.domain.colegium.entity.Alumno;
import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;
import org.jboss.portletbridge.seam.PortletScope;
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
import org.jboss.seam.security.Credentials;


@Name("CDocenteIngresoNotas")
@Scope(ScopeType.SESSION)
@PortletScope(PortletScope.ScopeType.APPLICATION_SCOPE)
@AutoCreate
public class CDocenteIngresoNotas implements ICDocenteIngresoNotas {

	
	@In
	Credentials credentials;

	@Logger
	private Log log;
	
	@In
	StatusMessages statusMessages;
	
	@In
	private MatriculaAlumnoDAO matriculaAlumnoDAO;
	
	@In
	@Out
	PeriodoAcademicoSeccionCursoDAO periodoAcademicoSeccionCursoDAO;
	

	@In
	@Out	
	PeriodoAcademicoHome  periodoAcademicoHome;
	
	@In
	@Out
	SubPeriodoAcademicoHome subPeriodoAcademicoHome;
	
	@DataModel
	List <BeanDocenteIngresoNotas> beanDocenteIngresoNotasList;
	
	BeanDocenteIngresoNotas beanDocenteIngresoNotas ;
	
	@In
	@Out
	CDocenteDatosPrincipales CDocenteDatosPrincipales ; 
	
	public void iniciarIngresoNotas() {
		try {
			log.info("inicio Ingreso Notas	");
			CDocenteDatosPrincipales.inicializar();
			
			beanDocenteIngresoNotasList = new ArrayList<BeanDocenteIngresoNotas>() ;
			List<Alumno> alumnos  = matriculaAlumnoDAO.obtenerAlumnosSeccion((long)27);
			PeriodoAcademicoSeccionCurso periodoAcademicoSeccionCurso = periodoAcademicoSeccionCursoDAO.obtenerPASCxID((long)6);
			
			//Si existe
			Iterator<Alumno> it =  alumnos.iterator();
			long idEval = -1; // Si es nuevo
			//long idSubPeriodo = CDocenteDatosPrincipales.subPeriodoAcademicoHome.getPeriodoAcademicoIdPeriodoAcademico();
			long idSubPeriodo = subPeriodoAcademicoHome.getPeriodoAcademicoIdPeriodoAcademico();
			BigDecimal nota = new BigDecimal(0.00);
			while (it.hasNext()){
				Alumno alumno =  it.next();
				BeanDocenteIngresoNotas beanDocenteIngresoNotas = new BeanDocenteIngresoNotas(alumno, idEval ,idSubPeriodo, new Date(), nota);
				beanDocenteIngresoNotasList.add(beanDocenteIngresoNotas);
			}
			log.info("beanDocenteAsistencias.size:"+beanDocenteIngresoNotasList.size());
		
		}catch (Exception e) {
			statusMessages.add(e.getMessage());
			log.error(e);	// TODO: handle exception
		}	 
	}

	public void mostrarIngresoNotas() {
		// TODO Auto-generated method stub

	}

	public void ingresarNotas() {
		// TODO Auto-generated method stub

	}

}
