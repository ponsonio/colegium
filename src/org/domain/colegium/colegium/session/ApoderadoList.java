package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("apoderadoList")
public class ApoderadoList extends EntityQuery<Apoderado>
{

    private static final String EJBQL = "select apoderado from Apoderado apoderado";

    private static final String[] RESTRICTIONS = {
    };

    private Apoderado apoderado = new Apoderado();

    public ApoderadoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Apoderado getApoderado()
    {
        return apoderado;
    }
}
