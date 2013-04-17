package org.domain.colegium.entity;
// Generated Mar 13, 2012 10:24:56 AM by Hibernate Tools 3.4.0.CR1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Justificacion generated by hbm2java
 */
@Entity
@Table(name="justificacion"
)
public class Justificacion  implements java.io.Serializable {


     private short idJustificacion;
     private String tipoJustificacion;
     private Set<Asistencia> asistencias = new HashSet<Asistencia>(0);

    public Justificacion() {
    }

	
    public Justificacion(short idJustificacion, String tipoJustificacion) {
        this.idJustificacion = idJustificacion;
        this.tipoJustificacion = tipoJustificacion;
    }
    public Justificacion(short idJustificacion, String tipoJustificacion, Set<Asistencia> asistencias) {
       this.idJustificacion = idJustificacion;
       this.tipoJustificacion = tipoJustificacion;
       this.asistencias = asistencias;
    }
   
     @Id 

    
    @Column(name="id_justificacion", unique=true, nullable=false)
    public short getIdJustificacion() {
        return this.idJustificacion;
    }
    
    public void setIdJustificacion(short idJustificacion) {
        this.idJustificacion = idJustificacion;
    }

    
    @Column(name="tipo_justificacion", nullable=false, length=20)
    @NotNull
    @Length(max=20)
    public String getTipoJustificacion() {
        return this.tipoJustificacion;
    }
    
    public void setTipoJustificacion(String tipoJustificacion) {
        this.tipoJustificacion = tipoJustificacion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="justificacion")
    public Set<Asistencia> getAsistencias() {
        return this.asistencias;
    }
    
    public void setAsistencias(Set<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }




}


