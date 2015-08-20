package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("reciboPensionDetalleHome")
public class ReciboPensionDetalleHome extends EntityHome<ReciboPensionDetalle>
{

    @In(create=true)
    ReciboPensionHome reciboPensionHome;
    @In(create=true)
    ConceptoHome conceptoHome;

    public void setReciboPensionDetalleIdReciboPension(String id)
    {
        setId(id);
    }

    public String getReciboPensionDetalleIdReciboPension()
    {
        return (String) getId();
    }

    @Override
    protected ReciboPensionDetalle createInstance()
    {
        ReciboPensionDetalle reciboPensionDetalle = new ReciboPensionDetalle();
        return reciboPensionDetalle;
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
        ReciboPension reciboPension=reciboPensionHome.getDefinedInstance();
        if ( reciboPension!=null )
        {
           getInstance().setReciboPension(reciboPension);
        }
        Concepto concepto=conceptoHome.getDefinedInstance();
        if ( concepto!=null )
        {
           getInstance().setConcepto(concepto);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getReciboPension()==null ) return false;
        if ( getInstance().getConcepto()==null ) return false;
        return true;
    }

    public ReciboPensionDetalle getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

