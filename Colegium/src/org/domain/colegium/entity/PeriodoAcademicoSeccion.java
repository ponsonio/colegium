package org.domain.colegium.entity;
// Generated Mar 13, 2012 10:24:56 AM by Hibernate Tools 3.4.0.CR1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

/**
 * PeriodoAcademicoSeccion generated by hbm2java
 */
@Entity
@Table(name="periodo_academico_seccion"
)
public class PeriodoAcademicoSeccion  implements java.io.Serializable {


     private long idPeriodoAcademicoSeccion;
     private Seccion seccion;
     private PeriodoAcademico periodoAcademico;
     private long idDocenteTutor;
     private Set<MatriculaAlumno> matriculaAlumnos = new HashSet<MatriculaAlumno>(0);
     private Set<PeriodoAcademicoSeccionCurso> periodoAcademicoSeccionCursos = new HashSet<PeriodoAcademicoSeccionCurso>(0);
     private Set<LibretaNotas> libretaNotases = new HashSet<LibretaNotas>(0);

    public PeriodoAcademicoSeccion() {
    }

	
    public PeriodoAcademicoSeccion(long idPeriodoAcademicoSeccion, Seccion seccion, PeriodoAcademico periodoAcademico, long idDocenteTutor) {
        this.idPeriodoAcademicoSeccion = idPeriodoAcademicoSeccion;
        this.seccion = seccion;
        this.periodoAcademico = periodoAcademico;
        this.idDocenteTutor = idDocenteTutor;
    }
    public PeriodoAcademicoSeccion(long idPeriodoAcademicoSeccion, Seccion seccion, PeriodoAcademico periodoAcademico, long idDocenteTutor, Set<MatriculaAlumno> matriculaAlumnos, Set<PeriodoAcademicoSeccionCurso> periodoAcademicoSeccionCursos, Set<LibretaNotas> libretaNotases) {
       this.idPeriodoAcademicoSeccion = idPeriodoAcademicoSeccion;
       this.seccion = seccion;
       this.periodoAcademico = periodoAcademico;
       this.idDocenteTutor = idDocenteTutor;
       this.matriculaAlumnos = matriculaAlumnos;
       this.periodoAcademicoSeccionCursos = periodoAcademicoSeccionCursos;
       this.libretaNotases = libretaNotases;
    }
   
     @Id 

    
    @Column(name="id_periodo_academico_seccion", unique=true, nullable=false)
    public long getIdPeriodoAcademicoSeccion() {
        return this.idPeriodoAcademicoSeccion;
    }
    
    public void setIdPeriodoAcademicoSeccion(long idPeriodoAcademicoSeccion) {
        this.idPeriodoAcademicoSeccion = idPeriodoAcademicoSeccion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_seccion", nullable=false)
    @NotNull
    public Seccion getSeccion() {
        return this.seccion;
    }
    
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_periodo_academico", nullable=false)
    @NotNull
    public PeriodoAcademico getPeriodoAcademico() {
        return this.periodoAcademico;
    }
    
    public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    
    @Column(name="id_docente_tutor", nullable=false)
    public long getIdDocenteTutor() {
        return this.idDocenteTutor;
    }
    
    public void setIdDocenteTutor(long idDocenteTutor) {
        this.idDocenteTutor = idDocenteTutor;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="periodoAcademicoSeccion")
    public Set<MatriculaAlumno> getMatriculaAlumnos() {
        return this.matriculaAlumnos;
    }
    
    public void setMatriculaAlumnos(Set<MatriculaAlumno> matriculaAlumnos) {
        this.matriculaAlumnos = matriculaAlumnos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="periodoAcademicoSeccion")
    public Set<PeriodoAcademicoSeccionCurso> getPeriodoAcademicoSeccionCursos() {
        return this.periodoAcademicoSeccionCursos;
    }
    
    public void setPeriodoAcademicoSeccionCursos(Set<PeriodoAcademicoSeccionCurso> periodoAcademicoSeccionCursos) {
        this.periodoAcademicoSeccionCursos = periodoAcademicoSeccionCursos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="periodoAcademicoSeccion")
    public Set<LibretaNotas> getLibretaNotases() {
        return this.libretaNotases;
    }
    
    public void setLibretaNotases(Set<LibretaNotas> libretaNotases) {
        this.libretaNotases = libretaNotases;
    }




}


