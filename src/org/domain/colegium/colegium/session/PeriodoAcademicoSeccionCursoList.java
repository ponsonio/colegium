package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("periodoAcademicoSeccionCursoList")
public class PeriodoAcademicoSeccionCursoList extends EntityQuery<PeriodoAcademicoSeccionCurso>
{

    private static final String EJBQL = "select periodoAcademicoSeccionCurso from PeriodoAcademicoSeccionCurso periodoAcademicoSeccionCurso";

    private static final String[] RESTRICTIONS = {
        "lower(periodoAcademicoSeccionCurso.formulaNotaFinal) like lower(concat(#{periodoAcademicoSeccionCursoList.periodoAcademicoSeccionCurso.formulaNotaFinal},'%'))",
    };

    private PeriodoAcademicoSeccionCurso periodoAcademicoSeccionCurso = new PeriodoAcademicoSeccionCurso();

    public PeriodoAcademicoSeccionCursoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public PeriodoAcademicoSeccionCurso getPeriodoAcademicoSeccionCurso()
    {
        return periodoAcademicoSeccionCurso;
    }
}
