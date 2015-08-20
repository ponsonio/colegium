package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gradoList")
public class GradoList extends EntityQuery<Grado>
{

    private static final String EJBQL = "select grado from Grado grado";

    private static final String[] RESTRICTIONS = {
        "lower(grado.nombre) like lower(concat(#{gradoList.grado.nombre},'%'))",
        "lower(grado.etiqueta) like lower(concat(#{gradoList.grado.etiqueta},'%'))",
    };

    private Grado grado = new Grado();

    public GradoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Grado getGrado()
    {
        return grado;
    }
}
