package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("justificacionHome")
public class JustificacionHome extends EntityHome<Justificacion>
{


    public void setJustificacionIdJustificacion(Short id)
    {
        setId(id);
    }

    public Short getJustificacionIdJustificacion()
    {
        return (Short) getId();
    }

    @Override
    protected Justificacion createInstance()
    {
        Justificacion justificacion = new Justificacion();
        return justificacion;
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
    }

    public boolean isWired()
    {
        return true;
    }

    public Justificacion getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<Asistencia> getAsistencias() {
        return getInstance() == null ?
            null : new ArrayList<Asistencia>( getInstance().getAsistencias() );
    }

}

