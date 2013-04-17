package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tipoEvaluacionList")
public class TipoEvaluacionList extends EntityQuery<TipoEvaluacion>
{

    private static final String EJBQL = "select tipoEvaluacion from TipoEvaluacion tipoEvaluacion";

    private static final String[] RESTRICTIONS = {
        "lower(tipoEvaluacion.nombre) like lower(concat(#{tipoEvaluacionList.tipoEvaluacion.nombre},'%'))",
        "lower(tipoEvaluacion.descripcion) like lower(concat(#{tipoEvaluacionList.tipoEvaluacion.descripcion},'%'))",
        "lower(tipoEvaluacion.codigo) like lower(concat(#{tipoEvaluacionList.tipoEvaluacion.codigo},'%'))",
    };

    private TipoEvaluacion tipoEvaluacion = new TipoEvaluacion();

    public TipoEvaluacionList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public TipoEvaluacion getTipoEvaluacion()
    {
        return tipoEvaluacion;
    }
}
