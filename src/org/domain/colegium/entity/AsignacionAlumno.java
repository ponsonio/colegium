package org.domain.colegium.entity;
// Generated Mar 13, 2012 10:24:56 AM by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

/**
 * AsignacionAlumno generated by hbm2java
 */
@Entity
@Table(name="asignacion_alumno"
)
public class AsignacionAlumno  implements java.io.Serializable {


     private long idAsignacionAlumno;
     private Asignacion asignacion;
     private Alumno alumno;
     private PeriodoAcademico periodoAcademico;
     private BigDecimal nota;

    public AsignacionAlumno() {
    }

	
    public AsignacionAlumno(long idAsignacionAlumno, Asignacion asignacion, Alumno alumno, PeriodoAcademico periodoAcademico) {
        this.idAsignacionAlumno = idAsignacionAlumno;
        this.asignacion = asignacion;
        this.alumno = alumno;
        this.periodoAcademico = periodoAcademico;
    }
    public AsignacionAlumno(long idAsignacionAlumno, Asignacion asignacion, Alumno alumno, PeriodoAcademico periodoAcademico, BigDecimal nota) {
       this.idAsignacionAlumno = idAsignacionAlumno;
       this.asignacion = asignacion;
       this.alumno = alumno;
       this.periodoAcademico = periodoAcademico;
       this.nota = nota;
    }
   
     @Id 

    
    @Column(name="id_asignacion_alumno", unique=true, nullable=false)
    public long getIdAsignacionAlumno() {
        return this.idAsignacionAlumno;
    }
    
    public void setIdAsignacionAlumno(long idAsignacionAlumno) {
        this.idAsignacionAlumno = idAsignacionAlumno;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_asignacion", nullable=false)
    @NotNull
    public Asignacion getAsignacion() {
        return this.asignacion;
    }
    
    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_alumno", nullable=false)
    @NotNull
    public Alumno getAlumno() {
        return this.alumno;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_sub_periodo", nullable=false)
    @NotNull
    public PeriodoAcademico getPeriodoAcademico() {
        return this.periodoAcademico;
    }
    
    public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    
    @Column(name="nota", precision=2)
    public BigDecimal getNota() {
        return this.nota;
    }
    
    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }




}

