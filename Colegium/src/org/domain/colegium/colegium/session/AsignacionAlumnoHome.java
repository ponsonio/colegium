package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("asignacionAlumnoHome")
public class AsignacionAlumnoHome extends EntityHome<AsignacionAlumno>
{

    @In(create=true)
    AsignacionHome asignacionHome;
    @In(create=true)
    AlumnoHome alumnoHome;
    @In(create=true)
    PeriodoAcademicoHome periodoAcademicoHome;

    public void setAsignacionAlumnoIdAsignacionAlumno(Long id)
    {
        setId(id);
    }

    public Long getAsignacionAlumnoIdAsignacionAlumno()
    {
        return (Long) getId();
    }

    @Override
    protected AsignacionAlumno createInstance()
    {
        AsignacionAlumno asignacionAlumno = new AsignacionAlumno();
        return asignacionAlumno;
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
        Asignacion asignacion=asignacionHome.getDefinedInstance();
        if ( asignacion!=null )
        {
           getInstance().setAsignacion(asignacion);
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
        if ( getInstance().getAsignacion()==null ) return false;
        if ( getInstance().getAlumno()==null ) return false;
        if ( getInstance().getPeriodoAcademico()==null ) return false;
        return true;
    }

    public AsignacionAlumno getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

