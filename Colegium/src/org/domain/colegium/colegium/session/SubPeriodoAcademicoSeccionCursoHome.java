package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("subPeriodoAcademicoSeccionCursoHome")
public class SubPeriodoAcademicoSeccionCursoHome extends EntityHome<SubPeriodoAcademicoSeccionCurso>
{

    @In(create=true)
    SeccionHome seccionHome;
    @In(create=true)
    PeriodoAcademicoHome periodoAcademicoHome;
    @In(create=true)
    CursoHome cursoHome;
    @In(create=true)
    PeriodoAcademicoSeccionCursoHome periodoAcademicoSeccionCursoHome;

    public void setSubPeriodoAcademicoSeccionCursoIdSubPeriodoAcademicoSeccionCurso(Long id)
    {
        setId(id);
    }

    public Long getSubPeriodoAcademicoSeccionCursoIdSubPeriodoAcademicoSeccionCurso()
    {
        return (Long) getId();
    }

    @Override
    protected SubPeriodoAcademicoSeccionCurso createInstance()
    {
        SubPeriodoAcademicoSeccionCurso subPeriodoAcademicoSeccionCurso = new SubPeriodoAcademicoSeccionCurso();
        return subPeriodoAcademicoSeccionCurso;
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
        Curso curso=cursoHome.getDefinedInstance();
        if ( curso!=null )
        {
           getInstance().setCurso(curso);
        }
        PeriodoAcademicoSeccionCurso periodoAcademicoSeccionCurso=periodoAcademicoSeccionCursoHome.getDefinedInstance();
        if ( periodoAcademicoSeccionCurso!=null )
        {
           getInstance().setPeriodoAcademicoSeccionCurso(periodoAcademicoSeccionCurso);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getSeccion()==null ) return false;
        if ( getInstance().getPeriodoAcademico()==null ) return false;
        if ( getInstance().getCurso()==null ) return false;
        if ( getInstance().getPeriodoAcademicoSeccionCurso()==null ) return false;
        return true;
    }

    public SubPeriodoAcademicoSeccionCurso getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<Asignacion> getAsignacions() {
        return getInstance() == null ?
            null : new ArrayList<Asignacion>( getInstance().getAsignacions() );
    }
    public List<Evaluacion> getEvaluacions() {
        return getInstance() == null ?
            null : new ArrayList<Evaluacion>( getInstance().getEvaluacions() );
    }
    public List<LibretaNotasSubperiodo> getLibretaNotasSubperiodos() {
        return getInstance() == null ?
            null : new ArrayList<LibretaNotasSubperiodo>( getInstance().getLibretaNotasSubperiodos() );
    }
    public List<Asistencia> getAsistencias() {
        return getInstance() == null ?
            null : new ArrayList<Asistencia>( getInstance().getAsistencias() );
    }

}

