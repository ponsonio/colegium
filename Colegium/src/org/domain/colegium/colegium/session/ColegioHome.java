package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("colegioHome")
public class ColegioHome extends EntityHome<Colegio>
{


    public void setColegioIdColegio(Long id)
    {
        setId(id);
    }

    public Long getColegioIdColegio()
    {
        return (Long) getId();
    }

    @Override
    protected Colegio createInstance()
    {
        Colegio colegio = new Colegio();
        return colegio;
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
    }

    public boolean isWired()
    {
        return true;
    }

    public Colegio getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<Alumno> getAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<Alumno>( getInstance().getAlumnos() );
    }
    public List<PeriodoAcademico> getPeriodoAcademicos() {
        return getInstance() == null ?
            null : new ArrayList<PeriodoAcademico>( getInstance().getPeriodoAcademicos() );
    }
    public List<RepositorioArchivos> getRepositorioArchivoses() {
        return getInstance() == null ?
            null : new ArrayList<RepositorioArchivos>( getInstance().getRepositorioArchivoses() );
    }
    public List<TipoEvaluacion> getTipoEvaluacions() {
        return getInstance() == null ?
            null : new ArrayList<TipoEvaluacion>( getInstance().getTipoEvaluacions() );
    }
    public List<Concepto> getConceptos() {
        return getInstance() == null ?
            null : new ArrayList<Concepto>( getInstance().getConceptos() );
    }
    public List<Aviso> getAvisos() {
        return getInstance() == null ?
            null : new ArrayList<Aviso>( getInstance().getAvisos() );
    }
    public List<CuentaBanco> getCuentaBancos() {
        return getInstance() == null ?
            null : new ArrayList<CuentaBanco>( getInstance().getCuentaBancos() );
    }
    public List<ResumenAlumno> getResumenAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<ResumenAlumno>( getInstance().getResumenAlumnos() );
    }
    public List<Seccion> getSeccions() {
        return getInstance() == null ?
            null : new ArrayList<Seccion>( getInstance().getSeccions() );
    }
    public List<TipoAsignacion> getTipoAsignacions() {
        return getInstance() == null ?
            null : new ArrayList<TipoAsignacion>( getInstance().getTipoAsignacions() );
    }
    public List<ColegioMedioContacto> getColegioMedioContactos() {
        return getInstance() == null ?
            null : new ArrayList<ColegioMedioContacto>( getInstance().getColegioMedioContactos() );
    }
    public List<Docente> getDocentes() {
        return getInstance() == null ?
            null : new ArrayList<Docente>( getInstance().getDocentes() );
    }
    public List<Curso> getCursos() {
        return getInstance() == null ?
            null : new ArrayList<Curso>( getInstance().getCursos() );
    }
    public List<Grado> getGrados() {
        return getInstance() == null ?
            null : new ArrayList<Grado>( getInstance().getGrados() );
    }

}

