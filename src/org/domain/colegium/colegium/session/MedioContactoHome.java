package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("medioContactoHome")
public class MedioContactoHome extends EntityHome<MedioContacto>
{


    public void setMedioContactoIdMedioContacto(Integer id)
    {
        setId(id);
    }

    public Integer getMedioContactoIdMedioContacto()
    {
        return (Integer) getId();
    }

    @Override
    protected MedioContacto createInstance()
    {
        MedioContacto medioContacto = new MedioContacto();
        return medioContacto;
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

    public MedioContacto getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<PersonaMedioContacto> getPersonaMedioContactos() {
        return getInstance() == null ?
            null : new ArrayList<PersonaMedioContacto>( getInstance().getPersonaMedioContactos() );
    }
    public List<ColegioMedioContacto> getColegioMedioContactos() {
        return getInstance() == null ?
            null : new ArrayList<ColegioMedioContacto>( getInstance().getColegioMedioContactos() );
    }

}

