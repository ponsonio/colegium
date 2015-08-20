package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("resumenAlumnoList")
public class ResumenAlumnoList extends EntityQuery<ResumenAlumno>
{

    private static final String EJBQL = "select resumenAlumno from ResumenAlumno resumenAlumno";

    private static final String[] RESTRICTIONS = {
    };

    private ResumenAlumno resumenAlumno;

    public ResumenAlumnoList()
    {
        resumenAlumno = new ResumenAlumno();
        resumenAlumno.setId( new ResumenAlumnoId() );
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public ResumenAlumno getResumenAlumno()
    {
        return resumenAlumno;
    }
}
