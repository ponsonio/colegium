package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("periodoAcademicoSeccionList")
public class PeriodoAcademicoSeccionList extends EntityQuery<PeriodoAcademicoSeccion>
{

    private static final String EJBQL = "select periodoAcademicoSeccion from PeriodoAcademicoSeccion periodoAcademicoSeccion";

    private static final String[] RESTRICTIONS = {
    };

    private PeriodoAcademicoSeccion periodoAcademicoSeccion = new PeriodoAcademicoSeccion();

    public PeriodoAcademicoSeccionList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public PeriodoAcademicoSeccion getPeriodoAcademicoSeccion()
    {
        return periodoAcademicoSeccion;
    }
}
