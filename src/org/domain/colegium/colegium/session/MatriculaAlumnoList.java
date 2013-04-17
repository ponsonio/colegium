package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("matriculaAlumnoList")
public class MatriculaAlumnoList extends EntityQuery<MatriculaAlumno>
{

    private static final String EJBQL = "select matriculaAlumno from MatriculaAlumno matriculaAlumno";

    private static final String[] RESTRICTIONS = {
        "lower(matriculaAlumno.usuario) like lower(concat(#{matriculaAlumnoList.matriculaAlumno.usuario},'%'))",
    };

    private MatriculaAlumno matriculaAlumno = new MatriculaAlumno();

    public MatriculaAlumnoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public MatriculaAlumno getMatriculaAlumno()
    {
        return matriculaAlumno;
    }
}
