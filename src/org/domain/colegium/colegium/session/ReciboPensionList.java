package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("reciboPensionList")
public class ReciboPensionList extends EntityQuery<ReciboPension>
{

    private static final String EJBQL = "select reciboPension from ReciboPension reciboPension";

    private static final String[] RESTRICTIONS = {
        "lower(reciboPension.idReciboPension) like lower(concat(#{reciboPensionList.reciboPension.idReciboPension},'%'))",
    };

    private ReciboPension reciboPension = new ReciboPension();

    public ReciboPensionList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public ReciboPension getReciboPension()
    {
        return reciboPension;
    }
}
