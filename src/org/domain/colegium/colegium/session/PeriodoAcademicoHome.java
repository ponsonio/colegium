package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("periodoAcademicoHome")
public class PeriodoAcademicoHome extends EntityHome<PeriodoAcademico>
{

    @In(create=true)
    ColegioHome colegioHome;
    @In(create=true)
    PeriodoAcademicoHome periodoAcademicoHome;

    public void setPeriodoAcademicoIdPeriodoAcademico(Long id)
    {
        setId(id);
    }

    public Long getPeriodoAcademicoIdPeriodoAcademico()
    {
        return (Long) getId();
    }

    @Override
    protected PeriodoAcademico createInstance()
    {
        PeriodoAcademico periodoAcademico = new PeriodoAcademico();
        return periodoAcademico;
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

    public PeriodoAcademico getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<Aviso> getAvisos() {
        return getInstance() == null ?
            null : new ArrayList<Aviso>( getInstance().getAvisos() );
    }
    public List<SubPeriodoAcademicoSeccionCurso> getSubPeriodoAcademicoSeccionCursos() {
        return getInstance() == null ?
            null : new ArrayList<SubPeriodoAcademicoSeccionCurso>( getInstance().getSubPeriodoAcademicoSeccionCursos() );
    }
    public List<LibretaNotasSubperiodo> getLibretaNotasSubperiodos() {
        return getInstance() == null ?
            null : new ArrayList<LibretaNotasSubperiodo>( getInstance().getLibretaNotasSubperiodos() );
    }
    public List<ResumenAlumno> getResumenAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<ResumenAlumno>( getInstance().getResumenAlumnos() );
    }
    public List<PeriodoAcademicoSeccion> getPeriodoAcademicoSeccions() {
        return getInstance() == null ?
            null : new ArrayList<PeriodoAcademicoSeccion>( getInstance().getPeriodoAcademicoSeccions() );
    }
    public List<Asistencia> getAsistencias() {
        return getInstance() == null ?
            null : new ArrayList<Asistencia>( getInstance().getAsistencias() );
    }
    public List<ReciboPension> getReciboPensions() {
        return getInstance() == null ?
            null : new ArrayList<ReciboPension>( getInstance().getReciboPensions() );
    }
    public List<EvaluacionAlumno> getEvaluacionAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<EvaluacionAlumno>( getInstance().getEvaluacionAlumnos() );
    }
    public List<LibretaNotas> getLibretaNotases() {
        return getInstance() == null ?
            null : new ArrayList<LibretaNotas>( getInstance().getLibretaNotases() );
    }
    public List<AsignacionAlumno> getAsignacionAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<AsignacionAlumno>( getInstance().getAsignacionAlumnos() );
    }
    public List<PeriodoAcademico> getPeriodoAcademicos() {
        return getInstance() == null ?
            null : new ArrayList<PeriodoAcademico>( getInstance().getPeriodoAcademicos() );
    }

}

