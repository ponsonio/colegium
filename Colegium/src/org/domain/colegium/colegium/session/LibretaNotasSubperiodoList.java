package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("libretaNotasSubperiodoList")
public class LibretaNotasSubperiodoList extends EntityQuery<LibretaNotasSubperiodo>
{

    private static final String EJBQL = "select libretaNotasSubperiodo from LibretaNotasSubperiodo libretaNotasSubperiodo";

    private static final String[] RESTRICTIONS = {
    };

    private LibretaNotasSubperiodo libretaNotasSubperiodo = new LibretaNotasSubperiodo();

    public LibretaNotasSubperiodoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public LibretaNotasSubperiodo getLibretaNotasSubperiodo()
    {
        return libretaNotasSubperiodo;
    }
}
