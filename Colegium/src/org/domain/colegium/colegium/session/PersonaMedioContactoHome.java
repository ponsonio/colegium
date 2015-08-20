package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("personaMedioContactoHome")
public class PersonaMedioContactoHome extends EntityHome<PersonaMedioContacto>
{

    @In(create=true)
    PersonaHome personaHome;
    @In(create=true)
    MedioContactoHome medioContactoHome;

    public void setPersonaMedioContactoId(PersonaMedioContactoId id)
    {
        setId(id);
    }

    public PersonaMedioContactoId getPersonaMedioContactoId()
    {
        return (PersonaMedioContactoId) getId();
    }

    public PersonaMedioContactoHome()
    {
        setPersonaMedioContactoId( new PersonaMedioContactoId() );
    }

    @Override
    public boolean isIdDefined()
    {
        if ( getPersonaMedioContactoId().getIdPersona()==0 ) return false;
        if ( getPersonaMedioContactoId().getIdMedioContacto()==0 ) return false;
        if ( getPersonaMedioContactoId().getReferencia()==null || "".equals( getPersonaMedioContactoId().getReferencia() ) ) return false;
        return true;
    }

    @Override
    protected PersonaMedioContacto createInstance()
    {
        PersonaMedioContacto personaMedioContacto = new PersonaMedioContacto();
        personaMedioContacto.setId( new PersonaMedioContactoId() );
        return personaMedioContacto;
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
        Persona persona=personaHome.getDefinedInstance();
        if ( persona!=null )
        {
           getInstance().setPersona(persona);
        }
        MedioContacto medioContacto=medioContactoHome.getDefinedInstance();
        if ( medioContacto!=null )
        {
           getInstance().setMedioContacto(medioContacto);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getPersona()==null ) return false;
        if ( getInstance().getMedioContacto()==null ) return false;
        return true;
    }

    public PersonaMedioContacto getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

