package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("periodoAcademicoSeccionHome")
public class PeriodoAcademicoSeccionHome extends EntityHome<PeriodoAcademicoSeccion>
{

    @In(create=true)
    SeccionHome seccionHome;
    @In(create=true)
    PeriodoAcademicoHome periodoAcademicoHome;

    public void setPeriodoAcademicoSeccionIdPeriodoAcademicoSeccion(Long id)
    {
        setId(id);
    }

    public Long getPeriodoAcademicoSeccionIdPeriodoAcademicoSeccion()
    {
        return (Long) getId();
    }

    @Override
    protected PeriodoAcademicoSeccion createInstance()
    {
        PeriodoAcademicoSeccion periodoAcademicoSeccion = new PeriodoAcademicoSeccion();
        return periodoAcademicoSeccion;
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
        Seccion seccion=seccionHome.getDefinedInstance();
        if ( seccion!=null )
        {
           getInstance().setSeccion(seccion);
        }
        PeriodoAcademico periodoAcademico=periodoAcademicoHome.getDefinedInstance();
        if ( periodoAcademico!=null )
        {
           getInstance().setPeriodoAcademico(periodoAcademico);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getSeccion()==null ) return false;
        if ( getInstance().getPeriodoAcademico()==null ) return false;
        return true;
    }

    public PeriodoAcademicoSeccion getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<MatriculaAlumno> getMatriculaAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<MatriculaAlumno>( getInstance().getMatriculaAlumnos() );
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

