package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("libretaNotasSubperiodoHome")
public class LibretaNotasSubperiodoHome extends EntityHome<LibretaNotasSubperiodo>
{

    @In(create=true)
    CursoHome cursoHome;
    @In(create=true)
    LibretaNotasHome libretaNotasHome;
    @In(create=true)
    SubPeriodoAcademicoSeccionCursoHome subPeriodoAcademicoSeccionCursoHome;
    @In(create=true)
    PeriodoAcademicoHome periodoAcademicoHome;

    public void setLibretaNotasSubperiodoIdLibretaNotasSubperiodo(Long id)
    {
        setId(id);
    }

    public Long getLibretaNotasSubperiodoIdLibretaNotasSubperiodo()
    {
        return (Long) getId();
    }

    @Override
    protected LibretaNotasSubperiodo createInstance()
    {
        LibretaNotasSubperiodo libretaNotasSubperiodo = new LibretaNotasSubperiodo();
        return libretaNotasSubperiodo;
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
        Curso curso=cursoHome.getDefinedInstance();
        if ( curso!=null )
        {
           getInstance().setCurso(curso);
        }
        LibretaNotas libretaNotas=libretaNotasHome.getDefinedInstance();
        if ( libretaNotas!=null )
        {
           getInstance().setLibretaNotas(libretaNotas);
        }
        SubPeriodoAcademicoSeccionCurso subPeriodoAcademicoSeccionCurso=subPeriodoAcademicoSeccionCursoHome.getDefinedInstance();
        if ( subPeriodoAcademicoSeccionCurso!=null )
        {
           getInstance().setSubPeriodoAcademicoSeccionCurso(subPeriodoAcademicoSeccionCurso);
        }
        PeriodoAcademico periodoAcademico=periodoAcademicoHome.getDefinedInstance();
        if ( periodoAcademico!=null )
        {
           getInstance().setPeriodoAcademico(periodoAcademico);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getCurso()==null ) return false;
        if ( getInstance().getLibretaNotas()==null ) return false;
        if ( getInstance().getSubPeriodoAcademicoSeccionCurso()==null ) return false;
        if ( getInstance().getPeriodoAcademico()==null ) return false;
        return true;
    }

    public LibretaNotasSubperiodo getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

