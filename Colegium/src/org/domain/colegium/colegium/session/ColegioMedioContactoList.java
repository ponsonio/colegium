package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("colegioMedioContactoList")
public class ColegioMedioContactoList extends EntityQuery<ColegioMedioContacto>
{

    private static final String EJBQL = "select colegioMedioContacto from ColegioMedioContacto colegioMedioContacto";

    private static final String[] RESTRICTIONS = {
        "lower(colegioMedioContacto.id.referencia) like lower(concat(#{colegioMedioContactoList.colegioMedioContacto.id.referencia},'%'))",
    };

    private ColegioMedioContacto colegioMedioContacto;

    public ColegioMedioContactoList()
    {
        colegioMedioContacto = new ColegioMedioContacto();
        colegioMedioContacto.setId( new ColegioMedioContactoId() );
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public ColegioMedioContacto getColegioMedioContacto()
    {
        return colegioMedioContacto;
    }
}
