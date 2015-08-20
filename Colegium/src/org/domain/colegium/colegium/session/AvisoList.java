package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("avisoList")
public class AvisoList extends EntityQuery<Aviso>
{

    private static final String EJBQL = "select aviso from Aviso aviso";

    private static final String[] RESTRICTIONS = {
        "lower(aviso.nombre) like lower(concat(#{avisoList.aviso.nombre},'%'))",
        "lower(aviso.descripcion) like lower(concat(#{avisoList.aviso.descripcion},'%'))",
        "lower(aviso.lugar) like lower(concat(#{avisoList.aviso.lugar},'%'))",
    };

    private Aviso aviso = new Aviso();

    public AvisoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Aviso getAviso()
    {
        return aviso;
    }
}
