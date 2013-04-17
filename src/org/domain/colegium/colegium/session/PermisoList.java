package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("permisoList")
public class PermisoList extends EntityQuery<Permiso>
{

    private static final String EJBQL = "select permiso from Permiso permiso";

    private static final String[] RESTRICTIONS = {
        "lower(permiso.comentarios) like lower(concat(#{permisoList.permiso.comentarios},'%'))",
    };

    private Permiso permiso = new Permiso();

    public PermisoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Permiso getPermiso()
    {
        return permiso;
    }
}
