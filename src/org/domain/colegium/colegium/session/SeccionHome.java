package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("seccionHome")
public class SeccionHome extends EntityHome<Seccion>
{

    @In(create=true)
    ColegioHome colegioHome;
    @In(create=true)
    GradoHome gradoHome;

    public void setSeccionIdSeccion(Long id)
    {
        setId(id);
    }

    public Long getSeccionIdSeccion()
    {
        return (Long) getId();
    }

    @Override
    protected Seccion createInstance()
    {
        Seccion seccion = new Seccion();
        return seccion;
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
        Grado grado=gradoHome.getDefinedInstance();
        if ( grado!=null )
        {
           getInstance().setGrado(grado);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getColegio()==null ) return false;
        if ( getInstance().getGrado()==null ) return false;
        return true;
    }

    public Seccion getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<AvisoSeccion> getAvisoSeccions() {
        return getInstance() == null ?
            null : new ArrayList<AvisoSeccion>( getInstance().getAvisoSeccions() );
    }
    public List<PeriodoAcademicoSeccion> getPeriodoAcademicoSeccions() {
        return getInstance() == null ?
            null : new ArrayList<PeriodoAcademicoSeccion>( getInstance().getPeriodoAcademicoSeccions() );
    }
    public List<SubPeriodoAcademicoSeccionCurso> getSubPeriodoAcademicoSeccionCursos() {
        return getInstance() == null ?
            null : new ArrayList<SubPeriodoAcademicoSeccionCurso>( getInstance().getSubPeriodoAcademicoSeccionCursos() );
    }
    public List<ResumenAlumno> getResumenAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<ResumenAlumno>( getInstance().getResumenAlumnos() );
    }
    public List<PeriodoAcademicoSeccionCurso> getPeriodoAcademicoSeccionCursos() {
        return getInstance() == null ?
            null : new ArrayList<PeriodoAcademicoSeccionCurso>( getInstance().getPeriodoAcademicoSeccionCursos() );
    }
    public List<LibretaNotas> getLibretaNotases() {
        return getInstance() == null ?
            null : new ArrayList<LibretaNotas>( getInstance().getLibretaNotases() );
    }

}

