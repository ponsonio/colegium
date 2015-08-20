package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("apoderadoHome")
public class ApoderadoHome extends EntityHome<Apoderado>
{

    @In(create=true)
    TipoApoderadoHome tipoApoderadoHome;
    @In(create=true)
    PersonaHome personaHome;

    public void setApoderadoIdPersona(Long id)
    {
        setId(id);
    }

    public Long getApoderadoIdPersona()
    {
        return (Long) getId();
    }

    @Override
    protected Apoderado createInstance()
    {
        Apoderado apoderado = new Apoderado();
        return apoderado;
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
        TipoApoderado tipoApoderado=tipoApoderadoHome.getDefinedInstance();
        if ( tipoApoderado!=null )
        {
           getInstance().setTipoApoderado(tipoApoderado);
        }
        Persona persona=personaHome.getDefinedInstance();
        if ( persona!=null )
        {
           getInstance().setPersona(persona);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getTipoApoderado()==null ) return false;
        if ( getInstance().getPersona()==null ) return false;
        return true;
    }

    public Apoderado getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

