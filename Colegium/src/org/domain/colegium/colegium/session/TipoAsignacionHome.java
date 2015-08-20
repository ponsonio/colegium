package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tipoAsignacionHome")
public class TipoAsignacionHome extends EntityHome<TipoAsignacion>
{

    @In(create=true)
    ColegioHome colegioHome;

    public void setTipoAsignacionIdTipoAsignacion(Short id)
    {
        setId(id);
    }

    public Short getTipoAsignacionIdTipoAsignacion()
    {
        return (Short) getId();
    }

    @Override
    protected TipoAsignacion createInstance()
    {
        TipoAsignacion tipoAsignacion = new TipoAsignacion();
        return tipoAsignacion;
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

    public TipoAsignacion getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<Asignacion> getAsignacions() {
        return getInstance() == null ?
            null : new ArrayList<Asignacion>( getInstance().getAsignacions() );
    }

}

