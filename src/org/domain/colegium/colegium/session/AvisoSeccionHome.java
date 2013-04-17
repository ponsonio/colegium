package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("avisoSeccionHome")
public class AvisoSeccionHome extends EntityHome<AvisoSeccion>
{

    @In(create=true)
    SeccionHome seccionHome;
    @In(create=true)
    AvisoHome avisoHome;

    public void setAvisoSeccionId(AvisoSeccionId id)
    {
        setId(id);
    }

    public AvisoSeccionId getAvisoSeccionId()
    {
        return (AvisoSeccionId) getId();
    }

    public AvisoSeccionHome()
    {
        setAvisoSeccionId( new AvisoSeccionId() );
    }

    @Override
    public boolean isIdDefined()
    {
        if ( getAvisoSeccionId().getIdAviso()==0 ) return false;
        if ( getAvisoSeccionId().getIdSeccion()==0 ) return false;
        return true;
    }

    @Override
    protected AvisoSeccion createInstance()
    {
        AvisoSeccion avisoSeccion = new AvisoSeccion();
        avisoSeccion.setId( new AvisoSeccionId() );
        return avisoSeccion;
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
        Seccion seccion=seccionHome.getDefinedInstance();
        if ( seccion!=null )
        {
           getInstance().setSeccion(seccion);
        }
        Aviso aviso=avisoHome.getDefinedInstance();
        if ( aviso!=null )
        {
           getInstance().setAviso(aviso);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getSeccion()==null ) return false;
        if ( getInstance().getAviso()==null ) return false;
        return true;
    }

    public AvisoSeccion getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

