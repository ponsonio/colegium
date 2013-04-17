package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("subPeriodoAcademicoSeccionCursoList")
public class SubPeriodoAcademicoSeccionCursoList extends EntityQuery<SubPeriodoAcademicoSeccionCurso>
{

    private static final String EJBQL = "select subPeriodoAcademicoSeccionCurso from SubPeriodoAcademicoSeccionCurso subPeriodoAcademicoSeccionCurso";

    private static final String[] RESTRICTIONS = {
        "lower(subPeriodoAcademicoSeccionCurso.formulaNotaSubPeriodo) like lower(concat(#{subPeriodoAcademicoSeccionCursoList.subPeriodoAcademicoSeccionCurso.formulaNotaSubPeriodo},'%'))",
    };

    private SubPeriodoAcademicoSeccionCurso subPeriodoAcademicoSeccionCurso = new SubPeriodoAcademicoSeccionCurso();

    public SubPeriodoAcademicoSeccionCursoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public SubPeriodoAcademicoSeccionCurso getSubPeriodoAcademicoSeccionCurso()
    {
        return subPeriodoAcademicoSeccionCurso;
    }
}
