package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("conceptoHome")
public class ConceptoHome extends EntityHome<Concepto>
{

    @In(create=true)
    ColegioHome colegioHome;

    public void setConceptoIdConcepto(Integer id)
    {
        setId(id);
    }

    public Integer getConceptoIdConcepto()
    {
        return (Integer) getId();
    }

    @Override
    protected Concepto createInstance()
    {
        Concepto concepto = new Concepto();
        return concepto;
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

    public Concepto getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<ReciboPensionDetalle> getReciboPensionDetalles() {
        return getInstance() == null ?
            null : new ArrayList<ReciboPensionDetalle>( getInstance().getReciboPensionDetalles() );
    }

}

