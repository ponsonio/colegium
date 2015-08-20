package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("monedaList")
public class MonedaList extends EntityQuery<Moneda>
{

    private static final String EJBQL = "select moneda from Moneda moneda";

    private static final String[] RESTRICTIONS = {
        "lower(moneda.nombre) like lower(concat(#{monedaList.moneda.nombre},'%'))",
        "lower(moneda.codigo) like lower(concat(#{monedaList.moneda.codigo},'%'))",
    };

    private Moneda moneda = new Moneda();

    public MonedaList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Moneda getMoneda()
    {
        return moneda;
    }
}
