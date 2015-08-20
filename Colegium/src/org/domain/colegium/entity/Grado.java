package org.domain.colegium.entity;
// Generated Mar 13, 2012 10:24:56 AM by Hibernate Tools 3.4.0.CR1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Grado generated by hbm2java
 */
@Entity
@Table(name="grado"
)
public class Grado  implements java.io.Serializable {


     private int idGrado;
     private Colegio colegio;
     private int correlativo;
     private String nombre;
     private String etiqueta;
     private Set<Seccion> seccions = new HashSet<Seccion>(0);
     private Set<Curso> cursos = new HashSet<Curso>(0);
     private Set<ResumenAlumno> resumenAlumnos = new HashSet<ResumenAlumno>(0);

    public Grado() {
    }

	
    public Grado(int idGrado, Colegio colegio, int correlativo, String nombre, String etiqueta) {
        this.idGrado = idGrado;
        this.colegio = colegio;
        this.correlativo = correlativo;
        this.nombre = nombre;
        this.etiqueta = etiqueta;
    }
    public Grado(int idGrado, Colegio colegio, int correlativo, String nombre, String etiqueta, Set<Seccion> seccions, Set<Curso> cursos, Set<ResumenAlumno> resumenAlumnos) {
       this.idGrado = idGrado;
       this.colegio = colegio;
       this.correlativo = correlativo;
       this.nombre = nombre;
       this.etiqueta = etiqueta;
       this.seccions = seccions;
       this.cursos = cursos;
       this.resumenAlumnos = resumenAlumnos;
    }
   
     @Id 

    
    @Column(name="id_grado", unique=true, nullable=false)
    public int getIdGrado() {
        return this.idGrado;
    }
    
    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
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

    
    @Column(name="correlativo", nullable=false)
    public int getCorrelativo() {
        return this.correlativo;
    }
    
    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    
    @Column(name="nombre", nullable=false)
    @NotNull
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="etiqueta", nullable=false, length=6)
    @NotNull
    @Length(max=6)
    public String getEtiqueta() {
        return this.etiqueta;
    }
    
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="grado")
    public Set<Seccion> getSeccions() {
        return this.seccions;
    }
    
    public void setSeccions(Set<Seccion> seccions) {
        this.seccions = seccions;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="grados")
    public Set<Curso> getCursos() {
        return this.cursos;
    }
    
    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="grado")
    public Set<ResumenAlumno> getResumenAlumnos() {
        return this.resumenAlumnos;
    }
    
    public void setResumenAlumnos(Set<ResumenAlumno> resumenAlumnos) {
        this.resumenAlumnos = resumenAlumnos;
    }




}


