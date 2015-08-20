package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityHome;

@Name("personaHome")
@Scope(ScopeType.SESSION)
public class PersonaHome extends EntityHome<Persona>
{

    @In(create=true)
    ApoderadoHome apoderadoHome;
    @In(create=true)
    DocenteHome docenteHome;
    @In(create=true)
    AlumnoHome alumnoHome;

    public void setPersonaIdPersona(Long id)
    {
        setId(id);
    }

    public Long getPersonaIdPersona()
    {
        return (Long) getId();
    }

    @Override
    protected Persona createInstance()
    {
        Persona persona = new Persona();
        return persona;
    }

    public void load()
    {
        if (isIdDefined())
        {
            wire();
        }
    }

    public void wire()
    {
        getInstance();
        Apoderado apoderado=apoderadoHome.getDefinedInstance();
        if ( apoderado!=null )
        {
           getInstance().setApoderado(apoderado);
        }
        Docente docente=docenteHome.getDefinedInstance();
        if ( docente!=null )
        {
           getInstance().setDocente(docente);
        }
        Alumno alumno=alumnoHome.getDefinedInstance();
        if ( alumno!=null )
        {
           getInstance().setAlumno(alumno);
        }
    }

    public boolean isWired()
    {
        return true;
    }

    public Persona getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<FotoPersona> getFotoPersonas() {
        return getInstance() == null ?
            null : new ArrayList<FotoPersona>( getInstance().getFotoPersonas() );
    }
    public List<Mensaje> getMensajes() {
        return getInstance() == null ?
            null : new ArrayList<Mensaje>( getInstance().getMensajes() );
    }
    public List<PersonaMedioContacto> getPersonaMedioContactos() {
        return getInstance() == null ?
            null : new ArrayList<PersonaMedioContacto>( getInstance().getPersonaMedioContactos() );
    }
    public List<Permiso> getPermisosForIdPersona() {
        return getInstance() == null ?
            null : new ArrayList<Permiso>( getInstance().getPermisosForIdPersona() );
    }
    public List<MensajeDestinatario> getMensajeDestinatarios() {
        return getInstance() == null ?
            null : new ArrayList<MensajeDestinatario>( getInstance().getMensajeDestinatarios() );
    }
    public List<Permiso> getPermisosForPersonaIdRegistro() {
        return getInstance() == null ?
            null : new ArrayList<Permiso>( getInstance().getPermisosForPersonaIdRegistro() );
    }

}

