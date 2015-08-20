package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("mensajeHome")
public class MensajeHome extends EntityHome<Mensaje>
{

    @In(create=true)
    PersonaHome personaHome;
    @In(create=true)
    MensajeHome mensajeHome;

    public void setMensajeIdMensaje(Long id)
    {
        setId(id);
    }

    public Long getMensajeIdMensaje()
    {
        return (Long) getId();
    }

    @Override
    protected Mensaje createInstance()
    {
        Mensaje mensaje = new Mensaje();
        return mensaje;
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
        Persona persona=personaHome.getDefinedInstance();
        if ( persona!=null )
        {
           getInstance().setPersona(persona);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getPersona()==null ) return false;
        if ( getInstance().getMensaje()==null ) return false;
        return true;
    }

    public Mensaje getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<MensajeDestinatario> getMensajeDestinatarios() {
        return getInstance() == null ?
            null : new ArrayList<MensajeDestinatario>( getInstance().getMensajeDestinatarios() );
    }
    public List<Mensaje> getMensajes() {
        return getInstance() == null ?
            null : new ArrayList<Mensaje>( getInstance().getMensajes() );
    }

}

