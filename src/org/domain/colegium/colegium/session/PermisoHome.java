package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("permisoHome")
public class PermisoHome extends EntityHome<Permiso>
{

    @In(create=true)
    PersonaHome personaHome;

    public void setPermisoIdPermiso(Long id)
    {
        setId(id);
    }

    public Long getPermisoIdPermiso()
    {
        return (Long) getId();
    }

    @Override
    protected Permiso createInstance()
    {
        Permiso permiso = new Permiso();
        return permiso;
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
        Persona personaByIdPersona=personaHome.getDefinedInstance();
        if ( personaByIdPersona!=null )
        {
           getInstance().setPersonaByIdPersona(personaByIdPersona);
        }
        Persona personaByPersonaIdRegistro=personaHome.getDefinedInstance();
        if ( personaByPersonaIdRegistro!=null )
        {
           getInstance().setPersonaByPersonaIdRegistro(personaByPersonaIdRegistro);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getPersonaByIdPersona()==null ) return false;
        if ( getInstance().getPersonaByPersonaIdRegistro()==null ) return false;
        return true;
    }

    public Permiso getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

