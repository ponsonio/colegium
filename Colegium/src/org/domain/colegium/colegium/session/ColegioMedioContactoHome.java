package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("colegioMedioContactoHome")
public class ColegioMedioContactoHome extends EntityHome<ColegioMedioContacto>
{

    @In(create=true)
    ColegioHome colegioHome;
    @In(create=true)
    MedioContactoHome medioContactoHome;

    public void setColegioMedioContactoId(ColegioMedioContactoId id)
    {
        setId(id);
    }

    public ColegioMedioContactoId getColegioMedioContactoId()
    {
        return (ColegioMedioContactoId) getId();
    }

    public ColegioMedioContactoHome()
    {
        setColegioMedioContactoId( new ColegioMedioContactoId() );
    }

    @Override
    public boolean isIdDefined()
    {
        if ( getColegioMedioContactoId().getIdColegio()==0 ) return false;
        if ( getColegioMedioContactoId().getIdMedioContacto()==0 ) return false;
        if ( getColegioMedioContactoId().getReferencia()==null || "".equals( getColegioMedioContactoId().getReferencia() ) ) return false;
        return true;
    }

    @Override
    protected ColegioMedioContacto createInstance()
    {
        ColegioMedioContacto colegioMedioContacto = new ColegioMedioContacto();
        colegioMedioContacto.setId( new ColegioMedioContactoId() );
        return colegioMedioContacto;
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
        MedioContacto medioContacto=medioContactoHome.getDefinedInstance();
        if ( medioContacto!=null )
        {
           getInstance().setMedioContacto(medioContacto);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getColegio()==null ) return false;
        if ( getInstance().getMedioContacto()==null ) return false;
        return true;
    }

    public ColegioMedioContacto getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

