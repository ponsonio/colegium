package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("periodoAcademicoSeccionCursoNotaHome")
public class PeriodoAcademicoSeccionCursoNotaHome extends EntityHome<PeriodoAcademicoSeccionCursoNota>
{

    @In(create=true)
    AlumnoHome alumnoHome;
    @In(create=true)
    PeriodoAcademicoSeccionCursoHome periodoAcademicoSeccionCursoHome;

    public void setPeriodoAcademicoSeccionCursoNotaIdPersona(Long id)
    {
        setId(id);
    }

    public Long getPeriodoAcademicoSeccionCursoNotaIdPersona()
    {
        return (Long) getId();
    }

    @Override
    protected PeriodoAcademicoSeccionCursoNota createInstance()
    {
        PeriodoAcademicoSeccionCursoNota periodoAcademicoSeccionCursoNota = new PeriodoAcademicoSeccionCursoNota();
        return periodoAcademicoSeccionCursoNota;
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
        Alumno alumno=alumnoHome.getDefinedInstance();
        if ( alumno!=null )
        {
           getInstance().setAlumno(alumno);
        }
        PeriodoAcademicoSeccionCurso periodoAcademicoSeccionCurso=periodoAcademicoSeccionCursoHome.getDefinedInstance();
        if ( periodoAcademicoSeccionCurso!=null )
        {
           getInstance().setPeriodoAcademicoSeccionCurso(periodoAcademicoSeccionCurso);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getAlumno()==null ) return false;
        if ( getInstance().getPeriodoAcademicoSeccionCurso()==null ) return false;
        return true;
    }

    public PeriodoAcademicoSeccionCursoNota getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

