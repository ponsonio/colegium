package org.domain.colegium.session.controler.docente;

import java.io.Serializable;
import java.util.Date;

import org.domain.colegium.entity.Alumno;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

 
@Name("beanDocenteAsistencia")
public class BeanDocenteAsistencia  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -599550720569599626L;

	Alumno alumno ;
	Date fecha;
	boolean falta = false;
	long idPeriodoAcademico;
	long idPeridoAcademicoSeccionCurso;
	int idCurso;
	
	
	public BeanDocenteAsistencia() {
		//super();
		// TODO Auto-generated constructor stub
	}

	
	
	public BeanDocenteAsistencia(Alumno alumno, Date fecha, boolean falta,
			long idPeriodoAcademico, long idPeridoAcademicoSeccionCurso,int idCurso) {
		super();
		this.alumno = alumno;
		this.fecha = fecha;
		this.falta = falta;
		this.idPeriodoAcademico = idPeriodoAcademico;
		this.idPeridoAcademicoSeccionCurso = idPeridoAcademicoSeccionCurso;
		this.idCurso = idCurso;
	}



	public int getIdCurso() {
		return idCurso;
	}



	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}



	public long getIdPeriodoAcademico() {
		return idPeriodoAcademico;
	}
	public void setIdPeriodoAcademico(long idPeriodoAcademico) {
		this.idPeriodoAcademico = idPeriodoAcademico;
	}
	public long getIdPeridoAcademicoSeccionCurso() {
		return idPeridoAcademicoSeccionCurso;
	}
	public void setIdPeridoAcademicoSeccionCurso(long idPeridoAcademicoSeccionCurso) {
		this.idPeridoAcademicoSeccionCurso = idPeridoAcademicoSeccionCurso;
	}

	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isFalta() {
		return falta;
	}
	public void setFalta(boolean falta) {
		this.falta = falta;
	}
	
	

}
