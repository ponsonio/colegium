package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("mensajeDestinatarioHome")
public class MensajeDestinatarioHome extends EntityHome<MensajeDestinatario>
{

    @In(create=true)
    PersonaHome personaHome;
    @In(create=true)
    MensajeHome mensajeHome;

    public void setMensajeDestinatarioId(MensajeDestinatarioId id)
    {
        setId(id);
    }

    public MensajeDestinatarioId getMensajeDestinatarioId()
    {
        return (MensajeDestinatarioId) getId();
    }

    public MensajeDestinatarioHome()
    {
        setMensajeDestinatarioId( new MensajeDestinatarioId() );
    }

    @Override
    public boolean isIdDefined()
    {
        if ( getMensajeDestinatarioId().getIdMensaje()==0 ) return false;
        if ( getMensajeDestinatarioId().getIdPersona()==0 ) return false;
        return true;
    }

    @Override
    protected MensajeDestinatario createInstance()
    {
        MensajeDestinatario mensajeDestinatario = new MensajeDestinatario();
        mensajeDestinatario.setId( new MensajeDestinatarioId() );
        return mensajeDestinatario;
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
        Mensaje mensaje=mensajeHome.getDefinedInstance();
        if ( mensaje!=null )
        {
           getInstance().setMensaje(mensaje);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getPersona()==null ) return false;
        if ( getInstance().getMensaje()==null ) return false;
        return true;
    }

    public MensajeDestinatario getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

