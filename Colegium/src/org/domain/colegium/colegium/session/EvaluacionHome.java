package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("evaluacionHome")
public class EvaluacionHome extends EntityHome<Evaluacion>
{

    @In(create=true)
    TipoEvaluacionHome tipoEvaluacionHome;
    @In(create=true)
    SubPeriodoAcademicoSeccionCursoHome subPeriodoAcademicoSeccionCursoHome;

    public void setEvaluacionIdEvaluacion(Long id)
    {
        setId(id);
    }

    public Long getEvaluacionIdEvaluacion()
    {
        return (Long) getId();
    }

    @Override
    protected Evaluacion createInstance()
    {
        Evaluacion evaluacion = new Evaluacion();
        return evaluacion;
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
        TipoEvaluacion tipoEvaluacion=tipoEvaluacionHome.getDefinedInstance();
        if ( tipoEvaluacion!=null )
        {
           getInstance().setTipoEvaluacion(tipoEvaluacion);
        }
        SubPeriodoAcademicoSeccionCurso subPeriodoAcademicoSeccionCurso=subPeriodoAcademicoSeccionCursoHome.getDefinedInstance();
        if ( subPeriodoAcademicoSeccionCurso!=null )
        {
           getInstance().setSubPeriodoAcademicoSeccionCurso(subPeriodoAcademicoSeccionCurso);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getTipoEvaluacion()==null ) return false;
        if ( getInstance().getSubPeriodoAcademicoSeccionCurso()==null ) return false;
        return true;
    }

    public Evaluacion getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<MaterialEvaluacion> getMaterialEvaluacions() {
        return getInstance() == null ?
            null : new ArrayList<MaterialEvaluacion>( getInstance().getMaterialEvaluacions() );
    }
    public List<EvaluacionAlumno> getEvaluacionAlumnos() {
        return getInstance() == null ?
            null : new ArrayList<EvaluacionAlumno>( getInstance().getEvaluacionAlumnos() );
    }

}

