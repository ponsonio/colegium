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
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

/**
 * TipoEvaluacion generated by hbm2java
 */
@Entity
@Name("tipoEvaluacion")
@Table(name="tipo_evaluacion")
public class TipoEvaluacion  implements java.io.Serializable {


     private int idTipoEvaluacion;
     private Colegio colegio;
     private String nombre;
     private String descripcion;
     private String codigo;
     private Set<Evaluacion> evaluacions = new HashSet<Evaluacion>(0);

    public TipoEvaluacion() {
    }

	
    public TipoEvaluacion(int idTipoEvaluacion, Colegio colegio, String nombre, String descripcion, String codigo) {
        this.idTipoEvaluacion = idTipoEvaluacion;
        this.colegio = colegio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }
    public TipoEvaluacion(int idTipoEvaluacion, Colegio colegio, String nombre, String descripcion, String codigo, Set<Evaluacion> evaluacions) {
       this.idTipoEvaluacion = idTipoEvaluacion;
       this.colegio = colegio;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.codigo = codigo;
       this.evaluacions = evaluacions;
    }
   
     @Id 

    
    @Column(name="id_tipo_evaluacion", unique=true, nullable=false)
    public int getIdTipoEvaluacion() {
        return this.idTipoEvaluacion;
    }
    
    public void setIdTipoEvaluacion(int idTipoEvaluacion) {
        this.idTipoEvaluacion = idTipoEvaluacion;
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

    
    @Column(name="nombre", nullable=false)
    @NotNull
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="descripcion", nullable=false)
    @NotNull
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="codigo", nullable=false, length=3)
    @NotNull
    @Length(max=3)
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoEvaluacion")
    public Set<Evaluacion> getEvaluacions() {
        return this.evaluacions;
    }
    
    public void setEvaluacions(Set<Evaluacion> evaluacions) {
        this.evaluacions = evaluacions;
    }




}


