package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("fotoPersonaList")
public class FotoPersonaList extends EntityQuery<FotoPersona>
{

    private static final String EJBQL = "select fotoPersona from FotoPersona fotoPersona";

    private static final String[] RESTRICTIONS = {
        "lower(fotoPersona.nombreArchivo) like lower(concat(#{fotoPersonaList.fotoPersona.nombreArchivo},'%'))",
    };

    private FotoPersona fotoPersona = new FotoPersona();

    public FotoPersonaList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public FotoPersona getFotoPersona()
    {
        return fotoPersona;
    }
}
