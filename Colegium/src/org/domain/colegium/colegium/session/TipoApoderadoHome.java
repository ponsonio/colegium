package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tipoApoderadoHome")
public class TipoApoderadoHome extends EntityHome<TipoApoderado>
{


    public void setTipoApoderadoIdTipoApoderado(Short id)
    {
        setId(id);
    }

    public Short getTipoApoderadoIdTipoApoderado()
    {
        return (Short) getId();
    }

    @Override
    protected TipoApoderado createInstance()
    {
        TipoApoderado tipoApoderado = new TipoApoderado();
        return tipoApoderado;
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

    public TipoApoderado getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<Apoderado> getApoderados() {
        return getInstance() == null ?
            null : new ArrayList<Apoderado>( getInstance().getApoderados() );
    }

}

