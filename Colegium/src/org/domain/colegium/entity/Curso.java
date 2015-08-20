package org.domain.colegium.entity;
// Generated Mar 13, 2012 10:24:56 AM by Hibernate Tools 3.4.0.CR1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Curso generated by hbm2java
 */
@Entity
@Table(name="curso"
)
public class Curso  implements java.io.Serializable {


     private int idCurso;
     private Colegio colegio;
     private String nombre;
     private char vigente;
     private Set<SubPeriodoAcademicoSeccionCurso> subPeriodoAcademicoSeccionCursos = new HashSet<SubPeriodoAcademicoSeccionCurso>(0);
     private Set<PeriodoAcademicoSeccionCurso> periodoAcademicoSeccionCursos = new HashSet<PeriodoAcademicoSeccionCurso>(0);
     private Set<Asistencia> asistencias = new HashSet<Asistencia>(0);
     private Set<LibretaNotasSubperiodo> libretaNotasSubperiodos = new HashSet<LibretaNotasSubperiodo>(0);
     private Set<LibretaNotasFinalesCurso> libretaNotasFinalesCursos = new HashSet<LibretaNotasFinalesCurso>(0);
     private Set<Grado> grados = new HashSet<Grado>(0);

    public Curso() {
    }

	
    public Curso(int idCurso, Colegio colegio, String nombre, char vigente) {
        this.idCurso = idCurso;
        this.colegio = colegio;
        this.nombre = nombre;
        this.vigente = vigente;
    }
    public Curso(int idCurso, Colegio colegio, String nombre, char vigente, Set<SubPeriodoAcademicoSeccionCurso> subPeriodoAcademicoSeccionCursos, Set<PeriodoAcademicoSeccionCurso> periodoAcademicoSeccionCursos, Set<Asistencia> asistencias, Set<LibretaNotasSubperiodo> libretaNotasSubperiodos, Set<LibretaNotasFinalesCurso> libretaNotasFinalesCursos, Set<Grado> grados) {
       this.idCurso = idCurso;
       this.colegio = colegio;
       this.nombre = nombre;
       this.vigente = vigente;
       this.subPeriodoAcademicoSeccionCursos = subPeriodoAcademicoSeccionCursos;
       this.periodoAcademicoSeccionCursos = periodoAcademicoSeccionCursos;
       this.asistencias = asistencias;
       this.libretaNotasSubperiodos = libretaNotasSubperiodos;
       this.libretaNotasFinalesCursos = libretaNotasFinalesCursos;
       this.grados = grados;
    }
   
     @Id 

    
    @Column(name="id_curso", unique=true, nullable=false)
    public int getIdCurso() {
        return this.idCurso;
    }
    
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_colegio", nullable=false)
    @NotNull
    public Colegio getColegio() {
        return this.colegio;
    }
    
    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    
    @Column(name="nombre", nullable=false, length=50)
    @NotNull
    @Length(max=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="vigente", nullable=false, length=1)
    public char getVigente() {
        return this.vigente;
    }
    
    public void setVigente(char vigente) {
        this.vigente = vigente;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="curso")
    public Set<SubPeriodoAcademicoSeccionCurso> getSubPeriodoAcademicoSeccionCursos() {
        return this.subPeriodoAcademicoSeccionCursos;
    }
    
    public void setSubPeriodoAcademicoSeccionCursos(Set<SubPeriodoAcademicoSeccionCurso> subPeriodoAcademicoSeccionCursos) {
        this.subPeriodoAcademicoSeccionCursos = subPeriodoAcademicoSeccionCursos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="curso")
    public Set<PeriodoAcademicoSeccionCurso> getPeriodoAcademicoSeccionCursos() {
        return this.periodoAcademicoSeccionCursos;
    }
    
    public void setPeriodoAcademicoSeccionCursos(Set<PeriodoAcademicoSeccionCurso> periodoAcademicoSeccionCursos) {
        this.periodoAcademicoSeccionCursos = periodoAcademicoSeccionCursos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="curso")
    public Set<Asistencia> getAsistencias() {
        return this.asistencias;
    }
    
    public void setAsistencias(Set<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="curso")
    public Set<LibretaNotasSubperiodo> getLibretaNotasSubperiodos() {
        return this.libretaNotasSubperiodos;
    }
    
    public void setLibretaNotasSubperiodos(Set<LibretaNotasSubperiodo> libretaNotasSubperiodos) {
        this.libretaNotasSubperiodos = libretaNotasSubperiodos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="curso")
    public Set<LibretaNotasFinalesCurso> getLibretaNotasFinalesCursos() {
        return this.libretaNotasFinalesCursos;
    }
    
    public void setLibretaNotasFinalesCursos(Set<LibretaNotasFinalesCurso> libretaNotasFinalesCursos) {
        this.libretaNotasFinalesCursos = libretaNotasFinalesCursos;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="curso_grado", joinColumns = { 
        @JoinColumn(name="id_curso", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="id_grado", nullable=false, updatable=false) })
    public Set<Grado> getGrados() {
        return this.grados;
    }
    
    public void setGrados(Set<Grado> grados) {
        this.grados = grados;
    }




}


