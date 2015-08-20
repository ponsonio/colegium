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
 * LibretaNotas generated by hbm2java
 */
@Entity
@Table(name="libreta_notas"
)
public class LibretaNotas  implements java.io.Serializable {


     private long idLibretaNotas;
     private PeriodoAcademicoSeccion periodoAcademicoSeccion;
     private Seccion seccion;
     private Alumno alumno;
     private PeriodoAcademico periodoAcademico;
     private Set<LibretaNotasSubperiodo> libretaNotasSubperiodos = new HashSet<LibretaNotasSubperiodo>(0);
     private Set<LibretaNotasFinalesCurso> libretaNotasFinalesCursos = new HashSet<LibretaNotasFinalesCurso>(0);

    public LibretaNotas() {
    }

	
    public LibretaNotas(long idLibretaNotas, PeriodoAcademicoSeccion periodoAcademicoSeccion, Seccion seccion, Alumno alumno, PeriodoAcademico periodoAcademico) {
        this.idLibretaNotas = idLibretaNotas;
        this.periodoAcademicoSeccion = periodoAcademicoSeccion;
        this.seccion = seccion;
        this.alumno = alumno;
        this.periodoAcademico = periodoAcademico;
    }
    public LibretaNotas(long idLibretaNotas, PeriodoAcademicoSeccion periodoAcademicoSeccion, Seccion seccion, Alumno alumno, PeriodoAcademico periodoAcademico, Set<LibretaNotasSubperiodo> libretaNotasSubperiodos, Set<LibretaNotasFinalesCurso> libretaNotasFinalesCursos) {
       this.idLibretaNotas = idLibretaNotas;
       this.periodoAcademicoSeccion = periodoAcademicoSeccion;
       this.seccion = seccion;
       this.alumno = alumno;
       this.periodoAcademico = periodoAcademico;
       this.libretaNotasSubperiodos = libretaNotasSubperiodos;
       this.libretaNotasFinalesCursos = libretaNotasFinalesCursos;
    }
   
     @Id 

    
    @Column(name="id_libreta_notas", unique=true, nullable=false)
    public long getIdLibretaNotas() {
        return this.idLibretaNotas;
    }
    
    public void setIdLibretaNotas(long idLibretaNotas) {
        this.idLibretaNotas = idLibretaNotas;
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
    @JoinColumn(name="id_seccion", nullable=false)
    @NotNull
    public Seccion getSeccion() {
        return this.seccion;
    }
    
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
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
    @JoinColumn(name="id_periodo_academico", nullable=false)
    @NotNull
    public PeriodoAcademico getPeriodoAcademico() {
        return this.periodoAcademico;
    }
    
    public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="libretaNotas")
    public Set<LibretaNotasSubperiodo> getLibretaNotasSubperiodos() {
        return this.libretaNotasSubperiodos;
    }
    
    public void setLibretaNotasSubperiodos(Set<LibretaNotasSubperiodo> libretaNotasSubperiodos) {
        this.libretaNotasSubperiodos = libretaNotasSubperiodos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="libretaNotas")
    public Set<LibretaNotasFinalesCurso> getLibretaNotasFinalesCursos() {
        return this.libretaNotasFinalesCursos;
    }
    
    public void setLibretaNotasFinalesCursos(Set<LibretaNotasFinalesCurso> libretaNotasFinalesCursos) {
        this.libretaNotasFinalesCursos = libretaNotasFinalesCursos;
    }




}


