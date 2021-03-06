package org.domain.colegium.entity;
// Generated Mar 13, 2012 10:24:56 AM by Hibernate Tools 3.4.0.CR1


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Mensaje generated by hbm2java
 */
@Entity
@Table(name="mensaje"
)
public class Mensaje  implements java.io.Serializable {


     private long idMensaje;
     private Persona persona;
     private Mensaje mensaje;
     private String mensaje_1;
     private Date fecha;
     private String asunto;
     private Set<MensajeDestinatario> mensajeDestinatarios = new HashSet<MensajeDestinatario>(0);
     private Set<Mensaje> mensajes = new HashSet<Mensaje>(0);

    public Mensaje() {
    }

	
    public Mensaje(long idMensaje, Persona persona, Mensaje mensaje, String mensaje_1, Date fecha, String asunto) {
        this.idMensaje = idMensaje;
        this.persona = persona;
        this.mensaje = mensaje;
        this.mensaje_1 = mensaje_1;
        this.fecha = fecha;
        this.asunto = asunto;
    }
    public Mensaje(long idMensaje, Persona persona, Mensaje mensaje, String mensaje_1, Date fecha, String asunto, Set<MensajeDestinatario> mensajeDestinatarios, Set<Mensaje> mensajes) {
       this.idMensaje = idMensaje;
       this.persona = persona;
       this.mensaje = mensaje;
       this.mensaje_1 = mensaje_1;
       this.fecha = fecha;
       this.asunto = asunto;
       this.mensajeDestinatarios = mensajeDestinatarios;
       this.mensajes = mensajes;
    }
   
     @Id 

    
    @Column(name="id_mensaje", unique=true, nullable=false)
    public long getIdMensaje() {
        return this.idMensaje;
    }
    
    public void setIdMensaje(long idMensaje) {
        this.idMensaje = idMensaje;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_persona_from", nullable=false)
    @NotNull
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id_mensaje", nullable=false)
    @NotNull
    public Mensaje getMensaje() {
        return this.mensaje;
    }
    
    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    
    @Column(name="mensaje", nullable=false)
    @NotNull
    public String getMensaje_1() {
        return this.mensaje_1;
    }
    
    public void setMensaje_1(String mensaje_1) {
        this.mensaje_1 = mensaje_1;
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

    
    @Column(name="asunto", nullable=false, length=50)
    @NotNull
    @Length(max=50)
    public String getAsunto() {
        return this.asunto;
    }
    
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="mensaje")
    public Set<MensajeDestinatario> getMensajeDestinatarios() {
        return this.mensajeDestinatarios;
    }
    
    public void setMensajeDestinatarios(Set<MensajeDestinatario> mensajeDestinatarios) {
        this.mensajeDestinatarios = mensajeDestinatarios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="mensaje")
    public Set<Mensaje> getMensajes() {
        return this.mensajes;
    }
    
    public void setMensajes(Set<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }




}


