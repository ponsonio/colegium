package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityHome;

@Name("resumenAlumnoHome")
@Scope(ScopeType.SESSION)
public class ResumenAlumnoHome extends EntityHome<ResumenAlumno>
{

    @In(create=true)
    SeccionHome seccionHome;
    @In(create=true)
    ColegioHome colegioHome;
    @In(create=true)
    AlumnoHome alumnoHome;
    @In(create=true)
    PeriodoAcademicoHome periodoAcademicoHome;
    @In(create=true)
    GradoHome gradoHome;

    public void setResumenAlumnoId(ResumenAlumnoId id)
    {
        setId(id);
    }

    public ResumenAlumnoId getResumenAlumnoId()
    {
        return (ResumenAlumnoId) getId();
    }

    public ResumenAlumnoHome()
    {
        setResumenAlumnoId( new ResumenAlumnoId() );
    }

    @Override
    public boolean isIdDefined()
    {
        if ( getResumenAlumnoId().getIdPeriodoAcademico()==0 ) return false;
        if ( getResumenAlumnoId().getIdPersona()==0 ) return false;
        return true;
    }

    @Override
    protected ResumenAlumno createInstance()
    {
        ResumenAlumno resumenAlumno = new ResumenAlumno();
        resumenAlumno.setId( new ResumenAlumnoId() );
        return resumenAlumno;
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
        Colegio colegio=colegioHome.getDefinedInstance();
        if ( colegio!=null )
        {
           getInstance().setColegio(colegio);
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
        Grado grado=gradoHome.getDefinedInstance();
        if ( grado!=null )
        {
           getInstance().setGrado(grado);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getSeccion()==null ) return false;
        if ( getInstance().getColegio()==null ) return false;
        if ( getInstance().getAlumno()==null ) return false;
        if ( getInstance().getPeriodoAcademico()==null ) return false;
        if ( getInstance().getGrado()==null ) return false;
        return true;
    }

    public ResumenAlumno getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

