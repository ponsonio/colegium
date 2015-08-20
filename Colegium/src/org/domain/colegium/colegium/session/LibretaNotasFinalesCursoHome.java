package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("libretaNotasFinalesCursoHome")
public class LibretaNotasFinalesCursoHome extends EntityHome<LibretaNotasFinalesCurso>
{

    @In(create=true)
    CursoHome cursoHome;
    @In(create=true)
    LibretaNotasHome libretaNotasHome;
    @In(create=true)
    PeriodoAcademicoSeccionCursoHome periodoAcademicoSeccionCursoHome;

    public void setLibretaNotasFinalesCursoId(Long id)
    {
        setId(id);
    }

    public Long getLibretaNotasFinalesCursoId()
    {
        return (Long) getId();
    }

    @Override
    protected LibretaNotasFinalesCurso createInstance()
    {
        LibretaNotasFinalesCurso libretaNotasFinalesCurso = new LibretaNotasFinalesCurso();
        return libretaNotasFinalesCurso;
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
        PeriodoAcademicoSeccionCurso periodoAcademicoSeccionCurso=periodoAcademicoSeccionCursoHome.getDefinedInstance();
        if ( periodoAcademicoSeccionCurso!=null )
        {
           getInstance().setPeriodoAcademicoSeccionCurso(periodoAcademicoSeccionCurso);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getCurso()==null ) return false;
        if ( getInstance().getLibretaNotas()==null ) return false;
        if ( getInstance().getPeriodoAcademicoSeccionCurso()==null ) return false;
        return true;
    }

    public LibretaNotasFinalesCurso getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

