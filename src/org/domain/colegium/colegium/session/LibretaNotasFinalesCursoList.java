package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("libretaNotasFinalesCursoList")
public class LibretaNotasFinalesCursoList extends EntityQuery<LibretaNotasFinalesCurso>
{

    private static final String EJBQL = "select libretaNotasFinalesCurso from LibretaNotasFinalesCurso libretaNotasFinalesCurso";

    private static final String[] RESTRICTIONS = {
    };

    private LibretaNotasFinalesCurso libretaNotasFinalesCurso = new LibretaNotasFinalesCurso();

    public LibretaNotasFinalesCursoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public LibretaNotasFinalesCurso getLibretaNotasFinalesCurso()
    {
        return libretaNotasFinalesCurso;
    }
}
