package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("asignacionAlumnoList")
public class AsignacionAlumnoList extends EntityQuery<AsignacionAlumno>
{

    private static final String EJBQL = "select asignacionAlumno from AsignacionAlumno asignacionAlumno";

    private static final String[] RESTRICTIONS = {
    };

    private AsignacionAlumno asignacionAlumno = new AsignacionAlumno();

    public AsignacionAlumnoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public AsignacionAlumno getAsignacionAlumno()
    {
        return asignacionAlumno;
    }
}
