package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("cuentaBancoList")
public class CuentaBancoList extends EntityQuery<CuentaBanco>
{

    private static final String EJBQL = "select cuentaBanco from CuentaBanco cuentaBanco";

    private static final String[] RESTRICTIONS = {
        "lower(cuentaBanco.numero) like lower(concat(#{cuentaBancoList.cuentaBanco.numero},'%'))",
    };

    private CuentaBanco cuentaBanco = new CuentaBanco();

    public CuentaBancoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public CuentaBanco getCuentaBanco()
    {
        return cuentaBanco;
    }
}
