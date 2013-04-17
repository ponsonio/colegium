package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("alumnoList")
public class AlumnoList extends EntityQuery<Alumno>
{

    private static final String EJBQL = "select alumno from Alumno alumno";

    private static final String[] RESTRICTIONS = {
    };

    private Alumno alumno = new Alumno();

    public AlumnoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Alumno getAlumno()
    {
        return alumno;
    }
}
