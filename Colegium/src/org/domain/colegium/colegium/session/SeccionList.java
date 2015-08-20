package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("seccionList")
public class SeccionList extends EntityQuery<Seccion>
{

    private static final String EJBQL = "select seccion from Seccion seccion";

    private static final String[] RESTRICTIONS = {
        "lower(seccion.etiqueta) like lower(concat(#{seccionList.seccion.etiqueta},'%'))",
    };

    private Seccion seccion = new Seccion();

    public SeccionList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Seccion getSeccion()
    {
        return seccion;
    }
}
