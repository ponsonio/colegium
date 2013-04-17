package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tipoEvaluacionHome")
@AutoCreate
public class TipoEvaluacionHome extends EntityHome<TipoEvaluacion>
{

    @In(create=true)
    ColegioHome colegioHome;

    public void setTipoEvaluacionIdTipoEvaluacion(Integer id)
    {
        setId(id);
    }

    public Integer getTipoEvaluacionIdTipoEvaluacion()
    {
        return (Integer) getId();
    }

    @Override
    protected TipoEvaluacion createInstance()
    {
        TipoEvaluacion tipoEvaluacion = new TipoEvaluacion();
        return tipoEvaluacion;
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

    public TipoEvaluacion getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<Evaluacion> getEvaluacions() {
        return getInstance() == null ?
            null : new ArrayList<Evaluacion>( getInstance().getEvaluacions() );
    }

}

