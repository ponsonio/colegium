package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("periodoAcademicoSeccionCursoHome")
public class PeriodoAcademicoSeccionCursoHome extends EntityHome<PeriodoAcademicoSeccionCurso>
{

    @In(create=true)
    PeriodoAcademicoSeccionHome periodoAcademicoSeccionHome;
    @In(create=true)
    SeccionHome seccionHome;
    @In(create=true)
    CursoHome cursoHome;
    @In(create=true)
    DocenteHome docenteHome;

    public void setPeriodoAcademicoSeccionCursoIdPeriodoAcademicoSeccionCurso(Long id)
    {
        setId(id);
    }

    public Long getPeriodoAcademicoSeccionCursoIdPeriodoAcademicoSeccionCurso()
    {
        return (Long) getId();
    }

    @Override
    protected PeriodoAcademicoSeccionCurso createInstance()
    {
        PeriodoAcademicoSeccionCurso periodoAcademicoSeccionCurso = new PeriodoAcademicoSeccionCurso();
        return periodoAcademicoSeccionCurso;
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
        Curso curso=cursoHome.getDefinedInstance();
        if ( curso!=null )
        {
           getInstance().setCurso(curso);
        }
        Docente docente=docenteHome.getDefinedInstance();
        if ( docente!=null )
        {
           getInstance().setDocente(docente);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getPeriodoAcademicoSeccion()==null ) return false;
        if ( getInstance().getSeccion()==null ) return false;
        if ( getInstance().getCurso()==null ) return false;
        if ( getInstance().getDocente()==null ) return false;
        return true;
    }

    public PeriodoAcademicoSeccionCurso getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<LibretaNotasFinalesCurso> getLibretaNotasFinalesCursos() {
        return getInstance() == null ?
            null : new ArrayList<LibretaNotasFinalesCurso>( getInstance().getLibretaNotasFinalesCursos() );
    }
    public List<SubPeriodoAcademicoSeccionCurso> getSubPeriodoAcademicoSeccionCursos() {
        return getInstance() == null ?
            null : new ArrayList<SubPeriodoAcademicoSeccionCurso>( getInstance().getSubPeriodoAcademicoSeccionCursos() );
    }
    public List<PeriodoAcademicoSeccionCursoNota> getPeriodoAcademicoSeccionCursoNotas() {
        return getInstance() == null ?
            null : new ArrayList<PeriodoAcademicoSeccionCursoNota>( getInstance().getPeriodoAcademicoSeccionCursoNotas() );
    }

}

