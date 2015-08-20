package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("monedaHome")
public class MonedaHome extends EntityHome<Moneda>
{


    public void setMonedaIdMoneda(Long id)
    {
        setId(id);
    }

    public Long getMonedaIdMoneda()
    {
        return (Long) getId();
    }

    @Override
    protected Moneda createInstance()
    {
        Moneda moneda = new Moneda();
        return moneda;
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

    public Moneda getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<ReciboPension> getReciboPensions() {
        return getInstance() == null ?
            null : new ArrayList<ReciboPension>( getInstance().getReciboPensions() );
    }

}

