package org.domain.colegium.session.controler.docente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.domain.colegium.entity.Alumno;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

 
@Name("beanDocenteIngresoNotas")
public class BeanDocenteIngresoNotas  implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5666279769888414828L;
	Alumno alumno ;
	long idEvaluacion;
	long idSubPeriodo;
	Date fechaIngreso;
    private BigDecimal nota;
	
	
	public BeanDocenteIngresoNotas(){}
	
	

	public BeanDocenteIngresoNotas(Alumno alumno, long idEvaluacion,
			long idSubPeriodo, Date fechaIngreso, BigDecimal nota) {
		super();
		this.alumno = alumno;
		this.idEvaluacion = idEvaluacion;
		this.idSubPeriodo = idSubPeriodo;
		this.fechaIngreso = fechaIngreso;
		this.nota = nota;
	}



	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public long getIdEvaluacion() {
		return idEvaluacion;
	}
	public void setIdEvaluacion(long idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}



	public long getIdSubPeriodo() {
		return idSubPeriodo;
	}



	public void setIdSubPeriodo(long idSubPeriodo) {
		this.idSubPeriodo = idSubPeriodo;
	}



	public Date getFechaIngreso() {
		return fechaIngreso;
	}



	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}



	public BigDecimal getNota() {
		return nota;
	}



	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}
	
	
	

}
