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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

/**
 * Colegio generated by hbm2java
 */
@Entity
@Table(name="colegio"
)
public class Colegio  implements java.io.Serializable {


     private long idColegio;
     private String codigo;
     private String direccion;
     private String nombre;
     private Set<Alumno> alumnos = new HashSet<Alumno>(0);
     private Set<PeriodoAcademico> periodoAcademicos = new HashSet<PeriodoAcademico>(0);
     private Set<RepositorioArchivos> repositorioArchivoses = new HashSet<RepositorioArchivos>(0);
     private Set<TipoEvaluacion> tipoEvaluacions = new HashSet<TipoEvaluacion>(0);
     private Set<Concepto> conceptos = new HashSet<Concepto>(0);
     private Set<Aviso> avisos = new HashSet<Aviso>(0);
     private Set<CuentaBanco> cuentaBancos = new HashSet<CuentaBanco>(0);
     private Set<Moneda> monedas = new HashSet<Moneda>(0);
     private Set<ResumenAlumno> resumenAlumnos = new HashSet<ResumenAlumno>(0);
     private Set<Seccion> seccions = new HashSet<Seccion>(0);
     private Set<TipoAsignacion> tipoAsignacions = new HashSet<TipoAsignacion>(0);
     private Set<ColegioMedioContacto> colegioMedioContactos = new HashSet<ColegioMedioContacto>(0);
     private Set<Docente> docentes = new HashSet<Docente>(0);
     private Set<Curso> cursos = new HashSet<Curso>(0);
     private Set<Grado> grados = new HashSet<Grado>(0);

    public Colegio() {
    }

	
    public Colegio(long idColegio, String direccion, String nombre) {
        this.idColegio = idColegio;
        this.direccion = direccion;
        this.nombre = nombre;
    }
    public Colegio(long idColegio, String codigo, String direccion, String nombre, Set<Alumno> alumnos, Set<PeriodoAcademico> periodoAcademicos, Set<RepositorioArchivos> repositorioArchivoses, Set<TipoEvaluacion> tipoEvaluacions, Set<Concepto> conceptos, Set<Aviso> avisos, Set<CuentaBanco> cuentaBancos, Set<Moneda> monedas, Set<ResumenAlumno> resumenAlumnos, Set<Seccion> seccions, Set<TipoAsignacion> tipoAsignacions, Set<ColegioMedioContacto> colegioMedioContactos, Set<Docente> docentes, Set<Curso> cursos, Set<Grado> grados) {
       this.idColegio = idColegio;
       this.codigo = codigo;
       this.direccion = direccion;
       this.nombre = nombre;
       this.alumnos = alumnos;
       this.periodoAcademicos = periodoAcademicos;
       this.repositorioArchivoses = repositorioArchivoses;
       this.tipoEvaluacions = tipoEvaluacions;
       this.conceptos = conceptos;
       this.avisos = avisos;
       this.cuentaBancos = cuentaBancos;
       this.monedas = monedas;
       this.resumenAlumnos = resumenAlumnos;
       this.seccions = seccions;
       this.tipoAsignacions = tipoAsignacions;
       this.colegioMedioContactos = colegioMedioContactos;
       this.docentes = docentes;
       this.cursos = cursos;
       this.grados = grados;
    }
   
     @Id 

    
    @Column(name="id_colegio", unique=true, nullable=false)
    public long getIdColegio() {
        return this.idColegio;
    }
    
    public void setIdColegio(long idColegio) {
        this.idColegio = idColegio;
    }

    
    @Column(name="codigo")
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    @Column(name="direccion", nullable=false)
    @NotNull
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="nombre", nullable=false)
    @NotNull
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<Alumno> getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<PeriodoAcademico> getPeriodoAcademicos() {
        return this.periodoAcademicos;
    }
    
    public void setPeriodoAcademicos(Set<PeriodoAcademico> periodoAcademicos) {
        this.periodoAcademicos = periodoAcademicos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<RepositorioArchivos> getRepositorioArchivoses() {
        return this.repositorioArchivoses;
    }
    
    public void setRepositorioArchivoses(Set<RepositorioArchivos> repositorioArchivoses) {
        this.repositorioArchivoses = repositorioArchivoses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<TipoEvaluacion> getTipoEvaluacions() {
        return this.tipoEvaluacions;
    }
    
    public void setTipoEvaluacions(Set<TipoEvaluacion> tipoEvaluacions) {
        this.tipoEvaluacions = tipoEvaluacions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<Concepto> getConceptos() {
        return this.conceptos;
    }
    
    public void setConceptos(Set<Concepto> conceptos) {
        this.conceptos = conceptos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<Aviso> getAvisos() {
        return this.avisos;
    }
    
    public void setAvisos(Set<Aviso> avisos) {
        this.avisos = avisos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<CuentaBanco> getCuentaBancos() {
        return this.cuentaBancos;
    }
    
    public void setCuentaBancos(Set<CuentaBanco> cuentaBancos) {
        this.cuentaBancos = cuentaBancos;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="moneda_colegio", joinColumns = { 
        @JoinColumn(name="id_colegio", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="id_moneda", nullable=false, updatable=false) })
    public Set<Moneda> getMonedas() {
        return this.monedas;
    }
    
    public void setMonedas(Set<Moneda> monedas) {
        this.monedas = monedas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<ResumenAlumno> getResumenAlumnos() {
        return this.resumenAlumnos;
    }
    
    public void setResumenAlumnos(Set<ResumenAlumno> resumenAlumnos) {
        this.resumenAlumnos = resumenAlumnos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<Seccion> getSeccions() {
        return this.seccions;
    }
    
    public void setSeccions(Set<Seccion> seccions) {
        this.seccions = seccions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<TipoAsignacion> getTipoAsignacions() {
        return this.tipoAsignacions;
    }
    
    public void setTipoAsignacions(Set<TipoAsignacion> tipoAsignacions) {
        this.tipoAsignacions = tipoAsignacions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<ColegioMedioContacto> getColegioMedioContactos() {
        return this.colegioMedioContactos;
    }
    
    public void setColegioMedioContactos(Set<ColegioMedioContacto> colegioMedioContactos) {
        this.colegioMedioContactos = colegioMedioContactos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<Docente> getDocentes() {
        return this.docentes;
    }
    
    public void setDocentes(Set<Docente> docentes) {
        this.docentes = docentes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<Curso> getCursos() {
        return this.cursos;
    }
    
    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="colegio")
    public Set<Grado> getGrados() {
        return this.grados;
    }
    
    public void setGrados(Set<Grado> grados) {
        this.grados = grados;
    }




}

