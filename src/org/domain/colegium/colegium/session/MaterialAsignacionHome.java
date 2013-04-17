package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("materialAsignacionHome")
public class MaterialAsignacionHome extends EntityHome<MaterialAsignacion>
{

    @In(create=true)
    AsignacionHome asignacionHome;
    @In(create=true)
    MaterialesHome materialesHome;

    public void setMaterialAsignacionId(MaterialAsignacionId id)
    {
        setId(id);
    }

    public MaterialAsignacionId getMaterialAsignacionId()
    {
        return (MaterialAsignacionId) getId();
    }

    public MaterialAsignacionHome()
    {
        setMaterialAsignacionId( new MaterialAsignacionId() );
    }

    @Override
    public boolean isIdDefined()
    {
        if ( getMaterialAsignacionId().getIdMaterial()==0 ) return false;
        if ( getMaterialAsignacionId().getIdAsignacion()==0 ) return false;
        return true;
    }

    @Override
    protected MaterialAsignacion createInstance()
    {
        MaterialAsignacion materialAsignacion = new MaterialAsignacion();
        materialAsignacion.setId( new MaterialAsignacionId() );
        return materialAsignacion;
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
        Asignacion asignacion=asignacionHome.getDefinedInstance();
        if ( asignacion!=null )
        {
           getInstance().setAsignacion(asignacion);
        }
        Materiales materiales=materialesHome.getDefinedInstance();
        if ( materiales!=null )
        {
           getInstance().setMateriales(materiales);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getAsignacion()==null ) return false;
        if ( getInstance().getMateriales()==null ) return false;
        return true;
    }

    public MaterialAsignacion getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

