package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("asignacionHome")
public class AsignacionHome extends EntityHome<Asignacion>
{

    @In(create=true)
    TipoAsignacionHome tipoAsignacionHome;
    @In(create=true)
    SubPeriodoAcademicoSeccionCursoHome subPeriodoAcademicoSeccionCursoHome;

    public void setAsignacionIdAsignacion(Long id)
    {
        setId(id);
    }

    public Long getAsignacionIdAsignacion()
    {
        return (Long) getId();
    }

    @Override
    protected Asignacion createInstance()
    {
        Asignacion asignacion = new Asignacion();
        return asignacion;
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
        TipoAsignacion tipoAsignacion=tipoAsignacionHome.getDefinedInstance();
        if ( tipoAsignacion!=null )
        {
           getInstance().setTipoAsignacion(tipoAsignacion);
        }
        SubPeriodoAcademicoSeccionCurso subPeriodoAcademicoSeccionCurso=subPeriodoAcademicoSeccionCursoHome.getDefinedInstance();
        if ( subPeriodoAcademicoSeccionCurso!=null )
        {
           getInstance().setSubPeriodoAcademicoSeccionCurso(subPeriodoAcademicoSeccionCurso);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getTipoAsignacion()==null ) return false;
        if ( getInstance().getSubPeriodoAcademicoSeccionCurso()==null ) return false;
        return true;
    }

    public Asignacion getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<AsignacionAlumno> getAsignacionAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<AsignacionAlumno>( getInstance().getAsignacionAlumnos() );
    }
    public List<MaterialAsignacion> getMaterialAsignacions() {
        return getInstance() == null ?
            null : new ArrayList<MaterialAsignacion>( getInstance().getMaterialAsignacions() );
    }

}

