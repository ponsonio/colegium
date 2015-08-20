package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("avisoHome")
public class AvisoHome extends EntityHome<Aviso>
{

    @In(create=true)
    ColegioHome colegioHome;
    @In(create=true)
    PeriodoAcademicoHome periodoAcademicoHome;

    public void setAvisoIdAviso(Long id)
    {
        setId(id);
    }

    public Long getAvisoIdAviso()
    {
        return (Long) getId();
    }

    @Override
    protected Aviso createInstance()
    {
        Aviso aviso = new Aviso();
        return aviso;
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
        PeriodoAcademico periodoAcademico=periodoAcademicoHome.getDefinedInstance();
        if ( periodoAcademico!=null )
        {
           getInstance().setPeriodoAcademico(periodoAcademico);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getColegio()==null ) return false;
        if ( getInstance().getPeriodoAcademico()==null ) return false;
        return true;
    }

    public Aviso getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<AvisoSeccion> getAvisoSeccions() {
        return getInstance() == null ?
            null : new ArrayList<AvisoSeccion>( getInstance().getAvisoSeccions() );
    }

}

