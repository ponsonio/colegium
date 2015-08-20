package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("materialesHome")
public class MaterialesHome extends EntityHome<Materiales>
{

    @In(create=true)
    RepositorioArchivosHome repositorioArchivosHome;

    public void setMaterialesIdMaterial(Long id)
    {
        setId(id);
    }

    public Long getMaterialesIdMaterial()
    {
        return (Long) getId();
    }

    @Override
    protected Materiales createInstance()
    {
        Materiales materiales = new Materiales();
        return materiales;
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
    }

    public boolean isWired()
    {
        if ( getInstance().getRepositorioArchivos()==null ) return false;
        return true;
    }

    public Materiales getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<MaterialAsignacion> getMaterialAsignacions() {
        return getInstance() == null ?
            null : new ArrayList<MaterialAsignacion>( getInstance().getMaterialAsignacions() );
    }
    public List<MaterialEvaluacion> getMaterialEvaluacions() {
        return getInstance() == null ?
            null : new ArrayList<MaterialEvaluacion>( getInstance().getMaterialEvaluacions() );
    }

}

