package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("asistenciaHome")
public class AsistenciaHome extends EntityHome<Asistencia>
{

    @In(create=true)
    JustificacionHome justificacionHome;
    @In(create=true)
    PeriodoAcademicoHome periodoAcademicoHome;
    @In(create=true)
    CursoHome cursoHome;
    @In(create=true)
    AlumnoHome alumnoHome;
    @In(create=true)
    SubPeriodoAcademicoSeccionCursoHome subPeriodoAcademicoSeccionCursoHome;

    public void setAsistenciaIdAsistencia(Long id)
    {
        setId(id);
    }

    public Long getAsistenciaIdAsistencia()
    {
        return (Long) getId();
    }

    @Override
    protected Asistencia createInstance()
    {
        Asistencia asistencia = new Asistencia();
        return asistencia;
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
        Justificacion justificacion=justificacionHome.getDefinedInstance();
        if ( justificacion!=null )
        {
           getInstance().setJustificacion(justificacion);
        }
        PeriodoAcademico periodoAcademico=periodoAcademicoHome.getDefinedInstance();
        if ( periodoAcademico!=null )
        {
           getInstance().setPeriodoAcademico(periodoAcademico);
        }
        Curso curso=cursoHome.getDefinedInstance();
        if ( curso!=null )
        {
           getInstance().setCurso(curso);
        }
        Alumno alumno=alumnoHome.getDefinedInstance();
        if ( alumno!=null )
        {
           getInstance().setAlumno(alumno);
        }
        SubPeriodoAcademicoSeccionCurso subPeriodoAcademicoSeccionCurso=subPeriodoAcademicoSeccionCursoHome.getDefinedInstance();
        if ( subPeriodoAcademicoSeccionCurso!=null )
        {
           getInstance().setSubPeriodoAcademicoSeccionCurso(subPeriodoAcademicoSeccionCurso);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getPeriodoAcademico()==null ) return false;
        if ( getInstance().getCurso()==null ) return false;
        if ( getInstance().getAlumno()==null ) return false;
        if ( getInstance().getSubPeriodoAcademicoSeccionCurso()==null ) return false;
        return true;
    }

    public Asistencia getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

