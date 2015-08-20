package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("libretaNotasList")
public class LibretaNotasList extends EntityQuery<LibretaNotas>
{

    private static final String EJBQL = "select libretaNotas from LibretaNotas libretaNotas";

    private static final String[] RESTRICTIONS = {
    };

    private LibretaNotas libretaNotas = new LibretaNotas();

    public LibretaNotasList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public LibretaNotas getLibretaNotas()
    {
        return libretaNotas;
    }
}
