package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("evaluacionList")
public class EvaluacionList extends EntityQuery<Evaluacion>
{

    private static final String EJBQL = "select evaluacion from Evaluacion evaluacion";

    private static final String[] RESTRICTIONS = {
        "lower(evaluacion.etiqueta) like lower(concat(#{evaluacionList.evaluacion.etiqueta},'%'))",
    };

    private Evaluacion evaluacion = new Evaluacion();

    public EvaluacionList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Evaluacion getEvaluacion()
    {
        return evaluacion;
    }
}
