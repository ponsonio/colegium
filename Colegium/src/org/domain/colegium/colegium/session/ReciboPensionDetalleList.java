package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("reciboPensionDetalleList")
public class ReciboPensionDetalleList extends EntityQuery<ReciboPensionDetalle>
{

    private static final String EJBQL = "select reciboPensionDetalle from ReciboPensionDetalle reciboPensionDetalle";

    private static final String[] RESTRICTIONS = {
        "lower(reciboPensionDetalle.idReciboPension) like lower(concat(#{reciboPensionDetalleList.reciboPensionDetalle.idReciboPension},'%'))",
    };

    private ReciboPensionDetalle reciboPensionDetalle = new ReciboPensionDetalle();

    public ReciboPensionDetalleList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public ReciboPensionDetalle getReciboPensionDetalle()
    {
        return reciboPensionDetalle;
    }
}
