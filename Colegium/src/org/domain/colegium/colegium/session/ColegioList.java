package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("colegioList")
public class ColegioList extends EntityQuery<Colegio>
{

    private static final String EJBQL = "select colegio from Colegio colegio";

    private static final String[] RESTRICTIONS = {
        "lower(colegio.codigo) like lower(concat(#{colegioList.colegio.codigo},'%'))",
        "lower(colegio.direccion) like lower(concat(#{colegioList.colegio.direccion},'%'))",
        "lower(colegio.nombre) like lower(concat(#{colegioList.colegio.nombre},'%'))",
    };

    private Colegio colegio = new Colegio();

    public ColegioList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Colegio getColegio()
    {
        return colegio;
    }
}
