package org.domain.colegium.session.controler.docente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import org.domain.colegium.dao.AsistenciaDAO;
import org.domain.colegium.dao.MatriculaAlumnoDAO;
import org.domain.colegium.dao.PeriodoAcademicoSeccionCursoDAO;
import org.domain.colegium.entity.Alumno;
import org.domain.colegium.entity.Asistencia;
import org.domain.colegium.entity.Curso;
import org.domain.colegium.entity.PeriodoAcademico;
import org.domain.colegium.entity.PeriodoAcademicoSeccionCurso;
import org.domain.colegium.entity.SubPeriodoAcademicoSeccionCurso;
import org.domain.colegium.session.controler.apoderado.DependienteSelecionadoEvent;
import org.jboss.portletbridge.seam.PortletScope;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;

@Name("CDocenteAsistenciaAlumno")
@Scope(ScopeType.SESSION)
@PortletScope(PortletScope.ScopeType.APPLICATION_SCOPE)
@AutoCreate
public class CDocenteAsistenciaAlumno implements ICDocenteAsistenciaAlumno, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2273167880301959720L;

	@In
	Credentials credentials;

	@Logger
	private Log log;
	
	@In
	StatusMessages statusMessages;
	
	//@In(create=true, required=true)
	//@Out
	@DataModel
	 List<BeanDocenteAsistencia> beanDocenteAsistencias  ;
	
	@In
	private MatriculaAlumnoDAO matriculaAlumnoDAO;

	@In
	private AsistenciaDAO  asistenciaDAO ;
	
	@In
	private PeriodoAcademicoSeccionCursoDAO periodoAcademicoSeccionCursoDAO;
	
	public void iniciarAsistenciaAlumnos() {
		try {
			System.out.println("ecoooooooooooooooooooooooo.......................");
			beanDocenteAsistencias = new ArrayList<BeanDocenteAsistencia>() ;
			List<Alumno> alumnos  = matriculaAlumnoDAO.obtenerAlumnosSeccion((long)27);
			PeriodoAcademicoSeccionCurso periodoAcademicoSeccionCurso = periodoAcademicoSeccionCursoDAO.obtenerPASCxID((long)27);
			Iterator<Alumno> it =  alumnos.iterator();
			while (it.hasNext()){
				Alumno alumno =  it.next();
				BeanDocenteAsistencia beanDocenteAsistencia = new BeanDocenteAsistencia(alumno, new Date(), false
						, periodoAcademicoSeccionCurso.getPeriodoAcademicoSeccion().getPeriodoAcademico().getIdPeriodoAcademico()
						,periodoAcademicoSeccionCurso.getIdPeriodoAcademicoSeccionCurso(),periodoAcademicoSeccionCurso.getCurso().getIdCurso());
				beanDocenteAsistencias.add(beanDocenteAsistencia);
				System.out.println("uno mas...");
			}
			System.out.println("beanDocenteAsistencias.size:"+beanDocenteAsistencias.size());
			
 		}catch (Exception e) {
			statusMessages.add(e.getMessage());
			log.error(e);	// TODO: handle exception
		}	 
		 

	}
	
	public void mostrarAsistenciaSeccion(){
		try{
			beanDocenteAsistencias = new ArrayList<BeanDocenteAsistencia>() ;
			SeccionSelecionadaEvent seccionSelecionadaEvent  = (SeccionSelecionadaEvent)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("SeccionSelecionadaEvent");
			//Obtengo información del dependiente
			if (seccionSelecionadaEvent != null){
				log.info("seccionSelecionadaEvent:"+seccionSelecionadaEvent.idseccion );	
				//List<Alumno> alumnos  = matriculaAlumnoDAO.obtenerAlumnosSeccion((long)seccionSelecionadaEvent.idseccion);
				List<Alumno> alumnos  = matriculaAlumnoDAO.obtenerAlumnosSeccion((long)27);
				Iterator<Alumno> it =  alumnos.iterator();
				PeriodoAcademicoSeccionCurso periodoAcademicoSeccionCurso = periodoAcademicoSeccionCursoDAO.obtenerPASCxID(seccionSelecionadaEvent.idseccion);
				while (it.hasNext()){
					Alumno alumno =  it.next();
					BeanDocenteAsistencia beanDocenteAsistencia = new BeanDocenteAsistencia(alumno, new Date(), false
							, periodoAcademicoSeccionCurso.getPeriodoAcademicoSeccion().getPeriodoAcademico().getIdPeriodoAcademico()
							,periodoAcademicoSeccionCurso.getIdPeriodoAcademicoSeccionCurso(),periodoAcademicoSeccionCurso.getCurso().getIdCurso());
					beanDocenteAsistencias.add(beanDocenteAsistencia);
					}
				System.out.println("beanDocenteAsistencias.size:"+beanDocenteAsistencias.size());
			}else{
				log.info("nada que mostrar..");
			}
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
	}
	
}
	public void ingresarAsistencia() {
		// TODO Auto-generated method stub
			try{
				Iterator<BeanDocenteAsistencia> it =  beanDocenteAsistencias.iterator();
				ArrayList<Asistencia>  asistencias = new ArrayList<Asistencia>();
				while (it.hasNext()){
					BeanDocenteAsistencia beanDocenteAsistencia =  it.next();
					if (beanDocenteAsistencia.isFalta() == true){
						log.info("Crear inasistencia idPersona"+beanDocenteAsistencia.alumno.getIdPersona());	
						Asistencia asistencia = new Asistencia();
						asistencia.setAlumno( beanDocenteAsistencia.alumno);
						asistencia.setFecha( beanDocenteAsistencia.fecha);
						if (beanDocenteAsistencia.isFalta())  asistencia.setAsistio( "0".charAt(0)) ; else asistencia.setAsistio( "1".charAt(0)) ; 
						asistencia.setJustificada("0".charAt(0));
						SubPeriodoAcademicoSeccionCurso subPeriodoAcademicoSeccionCurso = new SubPeriodoAcademicoSeccionCurso();
						subPeriodoAcademicoSeccionCurso.setIdSubPeriodoAcademicoSeccionCurso(beanDocenteAsistencia .getIdPeridoAcademicoSeccionCurso());
						asistencia.setSubPeriodoAcademicoSeccionCurso(subPeriodoAcademicoSeccionCurso);
						
						PeriodoAcademico periodoAcademico = new PeriodoAcademico();
						periodoAcademico.setIdPeriodoAcademico(beanDocenteAsistencia.getIdPeriodoAcademico());
						asistencia.setPeriodoAcademico(periodoAcademico);
						
						Curso curso = new Curso();
						curso.setIdCurso(beanDocenteAsistencia.getIdCurso());
						asistencia.setCurso(curso);
						asistencias.add(asistencia);
					}
				}
				asistenciaDAO.crearAsistencias(asistencias);
				statusMessages.add("Lista Completa");
				beanDocenteAsistencias = new ArrayList<BeanDocenteAsistencia>() ;
			}catch (Exception e) {
				statusMessages.add(e.getMessage()); 
				log.error(e);			
			}
		
	}

}
