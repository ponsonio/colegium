package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("docenteHome")
public class DocenteHome extends EntityHome<Docente>
{

    @In(create=true)
    ColegioHome colegioHome;
    @In(create=true)
    PersonaHome personaHome;

    public void setDocenteIdPersona(Long id)
    {
        setId(id);
    }

    public Long getDocenteIdPersona()
    {
        return (Long) getId();
    }

    @Override
    protected Docente createInstance()
    {
        Docente docente = new Docente();
        return docente;
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
        Persona persona=personaHome.getDefinedInstance();
        if ( persona!=null )
        {
           getInstance().setPersona(persona);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getColegio()==null ) return false;
        if ( getInstance().getPersona()==null ) return false;
        return true;
    }

    public Docente getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<PeriodoAcademicoSeccionCurso> getPeriodoAcademicoSeccionCursos() {
        return getInstance() == null ?
            null : new ArrayList<PeriodoAcademicoSeccionCurso>( getInstance().getPeriodoAcademicoSeccionCursos() );
    }

}

