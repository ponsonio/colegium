package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("periodoAcademicoList")
public class PeriodoAcademicoList extends EntityQuery<PeriodoAcademico>
{

    private static final String EJBQL = "select periodoAcademico from PeriodoAcademico periodoAcademico";

    private static final String[] RESTRICTIONS = {
        "lower(periodoAcademico.etiqueta) like lower(concat(#{periodoAcademicoList.periodoAcademico.etiqueta},'%'))",
    };

    private PeriodoAcademico periodoAcademico = new PeriodoAcademico();

    public PeriodoAcademicoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public PeriodoAcademico getPeriodoAcademico()
    {
        return periodoAcademico;
    }
}
