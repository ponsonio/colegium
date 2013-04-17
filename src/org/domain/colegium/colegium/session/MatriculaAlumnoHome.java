package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("matriculaAlumnoHome")
public class MatriculaAlumnoHome extends EntityHome<MatriculaAlumno>
{

    @In(create=true)
    PeriodoAcademicoSeccionHome periodoAcademicoSeccionHome;
    @In(create=true)
    AlumnoHome alumnoHome;

    public void setMatriculaAlumnoIdMatricula(Long id)
    {
        setId(id);
    }

    public Long getMatriculaAlumnoIdMatricula()
    {
        return (Long) getId();
    }

    @Override
    protected MatriculaAlumno createInstance()
    {
        MatriculaAlumno matriculaAlumno = new MatriculaAlumno();
        return matriculaAlumno;
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
        Alumno alumno=alumnoHome.getDefinedInstance();
        if ( alumno!=null )
        {
           getInstance().setAlumno(alumno);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getPeriodoAcademicoSeccion()==null ) return false;
        if ( getInstance().getAlumno()==null ) return false;
        return true;
    }

    public MatriculaAlumno getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

