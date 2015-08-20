package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("libretaNotasHome")
public class LibretaNotasHome extends EntityHome<LibretaNotas>
{

    @In(create=true)
    PeriodoAcademicoSeccionHome periodoAcademicoSeccionHome;
    @In(create=true)
    SeccionHome seccionHome;
    @In(create=true)
    AlumnoHome alumnoHome;
    @In(create=true)
    PeriodoAcademicoHome periodoAcademicoHome;

    public void setLibretaNotasIdLibretaNotas(Long id)
    {
        setId(id);
    }

    public Long getLibretaNotasIdLibretaNotas()
    {
        return (Long) getId();
    }

    @Override
    protected LibretaNotas createInstance()
    {
        LibretaNotas libretaNotas = new LibretaNotas();
        return libretaNotas;
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
        PeriodoAcademicoSeccion periodoAcademicoSeccion=periodoAcademicoSeccionHome.getDefinedInstance();
        if ( periodoAcademicoSeccion!=null )
        {
           getInstance().setPeriodoAcademicoSeccion(periodoAcademicoSeccion);
        }
        Seccion seccion=seccionHome.getDefinedInstance();
        if ( seccion!=null )
        {
           getInstance().setSeccion(seccion);
        }
        Alumno alumno=alumnoHome.getDefinedInstance();
        if ( alumno!=null )
        {
           getInstance().setAlumno(alumno);
        }
        PeriodoAcademico periodoAcademico=periodoAcademicoHome.getDefinedInstance();
        if ( periodoAcademico!=null )
        {
           getInstance().setPeriodoAcademico(periodoAcademico);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getPeriodoAcademicoSeccion()==null ) return false;
        if ( getInstance().getSeccion()==null ) return false;
        if ( getInstance().getAlumno()==null ) return false;
        if ( getInstance().getPeriodoAcademico()==null ) return false;
        return true;
    }

    public LibretaNotas getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<LibretaNotasSubperiodo> getLibretaNotasSubperiodos() {
        return getInstance() == null ?
            null : new ArrayList<LibretaNotasSubperiodo>( getInstance().getLibretaNotasSubperiodos() );
    }
    public List<LibretaNotasFinalesCurso> getLibretaNotasFinalesCursos() {
        return getInstance() == null ?
            null : new ArrayList<LibretaNotasFinalesCurso>( getInstance().getLibretaNotasFinalesCursos() );
    }

}

