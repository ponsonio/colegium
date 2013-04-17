package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("evaluacionAlumnoHome")
public class EvaluacionAlumnoHome extends EntityHome<EvaluacionAlumno>
{

    @In(create=true)
    EvaluacionHome evaluacionHome;
    @In(create=true)
    AlumnoHome alumnoHome;
    @In(create=true)
    PeriodoAcademicoHome periodoAcademicoHome;

    public void setEvaluacionAlumnoIdEvaluacionAlumno(Long id)
    {
        setId(id);
    }

    public Long getEvaluacionAlumnoIdEvaluacionAlumno()
    {
        return (Long) getId();
    }

    @Override
    protected EvaluacionAlumno createInstance()
    {
        EvaluacionAlumno evaluacionAlumno = new EvaluacionAlumno();
        return evaluacionAlumno;
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
        Evaluacion evaluacion=evaluacionHome.getDefinedInstance();
        if ( evaluacion!=null )
        {
           getInstance().setEvaluacion(evaluacion);
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
        if ( getInstance().getEvaluacion()==null ) return false;
        if ( getInstance().getAlumno()==null ) return false;
        if ( getInstance().getPeriodoAcademico()==null ) return false;
        return true;
    }

    public EvaluacionAlumno getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

