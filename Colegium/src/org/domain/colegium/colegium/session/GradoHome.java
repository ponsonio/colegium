package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gradoHome")
public class GradoHome extends EntityHome<Grado>
{

    @In(create=true)
    ColegioHome colegioHome;

    public void setGradoIdGrado(Integer id)
    {
        setId(id);
    }

    public Integer getGradoIdGrado()
    {
        return (Integer) getId();
    }

    @Override
    protected Grado createInstance()
    {
        Grado grado = new Grado();
        return grado;
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

    public Grado getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<Seccion> getSeccions() {
        return getInstance() == null ?
            null : new ArrayList<Seccion>( getInstance().getSeccions() );
    }
    public List<ResumenAlumno> getResumenAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<ResumenAlumno>( getInstance().getResumenAlumnos() );
    }

}

