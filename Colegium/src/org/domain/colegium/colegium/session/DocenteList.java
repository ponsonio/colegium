package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("docenteList")
public class DocenteList extends EntityQuery<Docente>
{

    private static final String EJBQL = "select docente from Docente docente";

    private static final String[] RESTRICTIONS = {
    };

    private Docente docente = new Docente();

    public DocenteList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Docente getDocente()
    {
        return docente;
    }
}
