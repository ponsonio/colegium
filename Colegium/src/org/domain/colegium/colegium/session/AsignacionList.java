package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("asignacionList")
public class AsignacionList extends EntityQuery<Asignacion>
{

    private static final String EJBQL = "select asignacion from Asignacion asignacion";

    private static final String[] RESTRICTIONS = {
        "lower(asignacion.descripcion) like lower(concat(#{asignacionList.asignacion.descripcion},'%'))",
        "lower(asignacion.etiqueta) like lower(concat(#{asignacionList.asignacion.etiqueta},'%'))",
    };

    private Asignacion asignacion = new Asignacion();

    public AsignacionList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Asignacion getAsignacion()
    {
        return asignacion;
    }
}
