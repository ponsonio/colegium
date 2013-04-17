package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("medioContactoList")
public class MedioContactoList extends EntityQuery<MedioContacto>
{

    private static final String EJBQL = "select medioContacto from MedioContacto medioContacto";

    private static final String[] RESTRICTIONS = {
        "lower(medioContacto.nombre) like lower(concat(#{medioContactoList.medioContacto.nombre},'%'))",
    };

    private MedioContacto medioContacto = new MedioContacto();

    public MedioContactoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public MedioContacto getMedioContacto()
    {
        return medioContacto;
    }
}
