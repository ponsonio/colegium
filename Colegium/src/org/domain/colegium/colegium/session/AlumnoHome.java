package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityHome;

@Name("alumnoHome")
@Scope(ScopeType.SESSION)
public class AlumnoHome extends EntityHome<Alumno>
{

    @In(create=true)
    ColegioHome colegioHome;
    @In(create=true)
    PersonaHome personaHome;
    @In(create=true)
    PeriodoAcademicoSeccionCursoNotaHome periodoAcademicoSeccionCursoNotaHome;

    public void setAlumnoIdPersona(Long id)
    {
        setId(id);
    }

    public Long getAlumnoIdPersona()
    {
        return (Long) getId();
    }

    @Override
    protected Alumno createInstance()
    {
        Alumno alumno = new Alumno();
        return alumno;
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
        Persona persona=personaHome.getDefinedInstance();
        if ( persona!=null )
        {
           getInstance().setPersona(persona);
        }
        PeriodoAcademicoSeccionCursoNota periodoAcademicoSeccionCursoNota=periodoAcademicoSeccionCursoNotaHome.getDefinedInstance();
        if ( periodoAcademicoSeccionCursoNota!=null )
        {
           getInstance().setPeriodoAcademicoSeccionCursoNota(periodoAcademicoSeccionCursoNota);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getColegio()==null ) return false;
        if ( getInstance().getPersona()==null ) return false;
        return true;
    }

    public Alumno getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<Asistencia> getAsistencias() {
        return getInstance() == null ?
            null : new ArrayList<Asistencia>( getInstance().getAsistencias() );
    }
    public List<MatriculaAlumno> getMatriculaAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<MatriculaAlumno>( getInstance().getMatriculaAlumnos() );
    }
    public List<ResumenAlumno> getResumenAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<ResumenAlumno>( getInstance().getResumenAlumnos() );
    }
    public List<EvaluacionAlumno> getEvaluacionAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<EvaluacionAlumno>( getInstance().getEvaluacionAlumnos() );
    }
    public List<AsignacionAlumno> getAsignacionAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<AsignacionAlumno>( getInstance().getAsignacionAlumnos() );
    }
    public List<ReciboPension> getReciboPensions() {
        return getInstance() == null ?
            null : new ArrayList<ReciboPension>( getInstance().getReciboPensions() );
    }
    public List<LibretaNotas> getLibretaNotases() {
        return getInstance() == null ?
            null : new ArrayList<LibretaNotas>( getInstance().getLibretaNotases() );
    }

}

