package org.domain.colegium.entity;
// Generated Mar 13, 2012 10:24:56 AM by Hibernate Tools 3.4.0.CR1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * MatriculaAlumno generated by hbm2java
 */
@Entity
@Table(name="matricula_alumno"
)
public class MatriculaAlumno  implements java.io.Serializable {


     private long idMatricula;
     private PeriodoAcademicoSeccion periodoAcademicoSeccion;
     private Alumno alumno;
     private String usuario;
     private Date fecha;

    public MatriculaAlumno() {
    }

    public MatriculaAlumno(long idMatricula, PeriodoAcademicoSeccion periodoAcademicoSeccion, Alumno alumno, String usuario, Date fecha) {
       this.idMatricula = idMatricula;
       this.periodoAcademicoSeccion = periodoAcademicoSeccion;
       this.alumno = alumno;
       this.usuario = usuario;
       this.fecha = fecha;
    }
   
     @Id 

    
    @Column(name="id_matricula", unique=true, nullable=false)
    public long getIdMatricula() {
        return this.idMatricula;
    }
    
    public void setIdMatricula(long idMatricula) {
        this.idMatricula = idMatricula;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_periodo_academico_seccion", nullable=false)
    @NotNull
    public PeriodoAcademicoSeccion getPeriodoAcademicoSeccion() {
        return this.periodoAcademicoSeccion;
    }
    
    public void setPeriodoAcademicoSeccion(PeriodoAcademicoSeccion periodoAcademicoSeccion) {
        this.periodoAcademicoSeccion = periodoAcademicoSeccion;
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

    
    @Column(name="usuario", nullable=false, length=25)
    @NotNull
    @Length(max=25)
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable=false, length=13)
    @NotNull
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


