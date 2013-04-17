package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("fotoPersonaHome")
public class FotoPersonaHome extends EntityHome<FotoPersona>
{

    @In(create=true)
    RepositorioArchivosHome repositorioArchivosHome;
    @In(create=true)
    PersonaHome personaHome;

    public void setFotoPersonaIdFoto(Long id)
    {
        setId(id);
    }

    public Long getFotoPersonaIdFoto()
    {
        return (Long) getId();
    }

    @Override
    protected FotoPersona createInstance()
    {
        FotoPersona fotoPersona = new FotoPersona();
        return fotoPersona;
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
        RepositorioArchivos repositorioArchivos=repositorioArchivosHome.getDefinedInstance();
        if ( repositorioArchivos!=null )
        {
           getInstance().setRepositorioArchivos(repositorioArchivos);
        }
        Persona persona=personaHome.getDefinedInstance();
        if ( persona!=null )
        {
           getInstance().setPersona(persona);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getRepositorioArchivos()==null ) return false;
        if ( getInstance().getPersona()==null ) return false;
        return true;
    }

    public FotoPersona getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

