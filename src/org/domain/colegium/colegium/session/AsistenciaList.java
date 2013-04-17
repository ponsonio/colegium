package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("asistenciaList")
public class AsistenciaList extends EntityQuery<Asistencia>
{

    private static final String EJBQL = "select asistencia from Asistencia asistencia";

    private static final String[] RESTRICTIONS = {
    };

    private Asistencia asistencia = new Asistencia();

    public AsistenciaList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Asistencia getAsistencia()
    {
        return asistencia;
    }
}
