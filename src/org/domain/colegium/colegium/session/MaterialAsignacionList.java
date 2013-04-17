package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("materialAsignacionList")
public class MaterialAsignacionList extends EntityQuery<MaterialAsignacion>
{

    private static final String EJBQL = "select materialAsignacion from MaterialAsignacion materialAsignacion";

    private static final String[] RESTRICTIONS = {
    };

    private MaterialAsignacion materialAsignacion;

    public MaterialAsignacionList()
    {
        materialAsignacion = new MaterialAsignacion();
        materialAsignacion.setId( new MaterialAsignacionId() );
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public MaterialAsignacion getMaterialAsignacion()
    {
        return materialAsignacion;
    }
}
