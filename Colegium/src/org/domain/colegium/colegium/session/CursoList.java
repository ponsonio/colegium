package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("cursoList")
public class CursoList extends EntityQuery<Curso>
{

    private static final String EJBQL = "select curso from Curso curso";

    private static final String[] RESTRICTIONS = {
        "lower(curso.nombre) like lower(concat(#{cursoList.curso.nombre},'%'))",
    };

    private Curso curso = new Curso();

    public CursoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Curso getCurso()
    {
        return curso;
    }
}
