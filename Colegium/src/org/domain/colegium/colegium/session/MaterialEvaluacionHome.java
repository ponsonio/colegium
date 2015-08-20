package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("materialEvaluacionHome")
public class MaterialEvaluacionHome extends EntityHome<MaterialEvaluacion>
{

    @In(create=true)
    EvaluacionHome evaluacionHome;
    @In(create=true)
    MaterialesHome materialesHome;

    public void setMaterialEvaluacionId(MaterialEvaluacionId id)
    {
        setId(id);
    }

    public MaterialEvaluacionId getMaterialEvaluacionId()
    {
        return (MaterialEvaluacionId) getId();
    }

    public MaterialEvaluacionHome()
    {
        setMaterialEvaluacionId( new MaterialEvaluacionId() );
    }

    @Override
    public boolean isIdDefined()
    {
        if ( getMaterialEvaluacionId().getIdMaterial()==0 ) return false;
        if ( getMaterialEvaluacionId().getIdEvaluacion()==0 ) return false;
        return true;
    }

    @Override
    protected MaterialEvaluacion createInstance()
    {
        MaterialEvaluacion materialEvaluacion = new MaterialEvaluacion();
        materialEvaluacion.setId( new MaterialEvaluacionId() );
        return materialEvaluacion;
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
        Evaluacion evaluacion=evaluacionHome.getDefinedInstance();
        if ( evaluacion!=null )
        {
           getInstance().setEvaluacion(evaluacion);
        }
        Materiales materiales=materialesHome.getDefinedInstance();
        if ( materiales!=null )
        {
           getInstance().setMateriales(materiales);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getEvaluacion()==null ) return false;
        if ( getInstance().getMateriales()==null ) return false;
        return true;
    }

    public MaterialEvaluacion getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

