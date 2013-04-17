package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("periodoAcademicoSeccionCursoNotaList")
public class PeriodoAcademicoSeccionCursoNotaList extends EntityQuery<PeriodoAcademicoSeccionCursoNota>
{

    private static final String EJBQL = "select periodoAcademicoSeccionCursoNota from PeriodoAcademicoSeccionCursoNota periodoAcademicoSeccionCursoNota";

    private static final String[] RESTRICTIONS = {
    };

    private PeriodoAcademicoSeccionCursoNota periodoAcademicoSeccionCursoNota = new PeriodoAcademicoSeccionCursoNota();

    public PeriodoAcademicoSeccionCursoNotaList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public PeriodoAcademicoSeccionCursoNota getPeriodoAcademicoSeccionCursoNota()
    {
        return periodoAcademicoSeccionCursoNota;
    }
}
