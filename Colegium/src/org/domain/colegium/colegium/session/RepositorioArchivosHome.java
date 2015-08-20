package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("repositorioArchivosHome")
public class RepositorioArchivosHome extends EntityHome<RepositorioArchivos>
{

    @In(create=true)
    ColegioHome colegioHome;

    public void setRepositorioArchivosIdRepositorio(Integer id)
    {
        setId(id);
    }

    public Integer getRepositorioArchivosIdRepositorio()
    {
        return (Integer) getId();
    }

    @Override
    protected RepositorioArchivos createInstance()
    {
        RepositorioArchivos repositorioArchivos = new RepositorioArchivos();
        return repositorioArchivos;
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
        Colegio colegio=colegioHome.getDefinedInstance();
        if ( colegio!=null )
        {
           getInstance().setColegio(colegio);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getColegio()==null ) return false;
        return true;
    }

    public RepositorioArchivos getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<Materiales> getMaterialeses() {
        return getInstance() == null ?
            null : new ArrayList<Materiales>( getInstance().getMaterialeses() );
    }
    public List<FotoPersona> getFotoPersonas() {
        return getInstance() == null ?
            null : new ArrayList<FotoPersona>( getInstance().getFotoPersonas() );
    }

}

