package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("materialesList")
public class MaterialesList extends EntityQuery<Materiales>
{

    private static final String EJBQL = "select materiales from Materiales materiales";

    private static final String[] RESTRICTIONS = {
        "lower(materiales.nombreArchivo) like lower(concat(#{materialesList.materiales.nombreArchivo},'%'))",
        "lower(materiales.descripcion) like lower(concat(#{materialesList.materiales.descripcion},'%'))",
    };

    private Materiales materiales = new Materiales();

    public MaterialesList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Materiales getMateriales()
    {
        return materiales;
    }
}
