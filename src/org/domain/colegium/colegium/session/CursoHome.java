package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("cursoHome")
public class CursoHome extends EntityHome<Curso>
{

    @In(create=true)
    ColegioHome colegioHome;

    public void setCursoIdCurso(Integer id)
    {
        setId(id);
    }

    public Integer getCursoIdCurso()
    {
        return (Integer) getId();
    }

    @Override
    protected Curso createInstance()
    {
        Curso curso = new Curso();
        return curso;
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
        Colegio colegio=colegioHome.getDefinedInstance();
        if ( colegio!=null )
        {
           getInstance().setColegio(colegio);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getColegio()==null ) return false;
        return true;
    }

    public Curso getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<SubPeriodoAcademicoSeccionCurso> getSubPeriodoAcademicoSeccionCursos() {
        return getInstance() == null ?
            null : new ArrayList<SubPeriodoAcademicoSeccionCurso>( getInstance().getSubPeriodoAcademicoSeccionCursos() );
    }
    public List<PeriodoAcademicoSeccionCurso> getPeriodoAcademicoSeccionCursos() {
        return getInstance() == null ?
            null : new ArrayList<PeriodoAcademicoSeccionCurso>( getInstance().getPeriodoAcademicoSeccionCursos() );
    }
    public List<Asistencia> getAsistencias() {
        return getInstance() == null ?
            null : new ArrayList<Asistencia>( getInstance().getAsistencias() );
    }
    public List<LibretaNotasSubperiodo> getLibretaNotasSubperiodos() {
        return getInstance() == null ?
            null : new ArrayList<LibretaNotasSubperiodo>( getInstance().getLibretaNotasSubperiodos() );
    }
    public List<LibretaNotasFinalesCurso> getLibretaNotasFinalesCursos() {
        return getInstance() == null ?
            null : new ArrayList<LibretaNotasFinalesCurso>( getInstance().getLibretaNotasFinalesCursos() );
    }

}

