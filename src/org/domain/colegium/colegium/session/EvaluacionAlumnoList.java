package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("evaluacionAlumnoList")
public class EvaluacionAlumnoList extends EntityQuery<EvaluacionAlumno>
{

    private static final String EJBQL = "select evaluacionAlumno from EvaluacionAlumno evaluacionAlumno";

    private static final String[] RESTRICTIONS = {
    };

    private EvaluacionAlumno evaluacionAlumno = new EvaluacionAlumno();

    public EvaluacionAlumnoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public EvaluacionAlumno getEvaluacionAlumno()
    {
        return evaluacionAlumno;
    }
}
