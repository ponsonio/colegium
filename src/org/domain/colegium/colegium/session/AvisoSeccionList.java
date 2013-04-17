package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("avisoSeccionList")
public class AvisoSeccionList extends EntityQuery<AvisoSeccion>
{

    private static final String EJBQL = "select avisoSeccion from AvisoSeccion avisoSeccion";

    private static final String[] RESTRICTIONS = {
    };

    private AvisoSeccion avisoSeccion;

    public AvisoSeccionList()
    {
        avisoSeccion = new AvisoSeccion();
        avisoSeccion.setId( new AvisoSeccionId() );
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public AvisoSeccion getAvisoSeccion()
    {
        return avisoSeccion;
    }
}
