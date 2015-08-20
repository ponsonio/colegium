package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tipoAsignacionList")
public class TipoAsignacionList extends EntityQuery<TipoAsignacion>
{

    private static final String EJBQL = "select tipoAsignacion from TipoAsignacion tipoAsignacion";

    private static final String[] RESTRICTIONS = {
        "lower(tipoAsignacion.nombre) like lower(concat(#{tipoAsignacionList.tipoAsignacion.nombre},'%'))",
    };

    private TipoAsignacion tipoAsignacion = new TipoAsignacion();

    public TipoAsignacionList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public TipoAsignacion getTipoAsignacion()
    {
        return tipoAsignacion;
    }
}
