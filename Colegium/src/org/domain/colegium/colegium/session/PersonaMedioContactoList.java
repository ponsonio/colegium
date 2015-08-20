package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("personaMedioContactoList")
public class PersonaMedioContactoList extends EntityQuery<PersonaMedioContacto>
{

    private static final String EJBQL = "select personaMedioContacto from PersonaMedioContacto personaMedioContacto";

    private static final String[] RESTRICTIONS = {
        "lower(personaMedioContacto.id.referencia) like lower(concat(#{personaMedioContactoList.personaMedioContacto.id.referencia},'%'))",
    };

    private PersonaMedioContacto personaMedioContacto;

    public PersonaMedioContactoList()
    {
        personaMedioContacto = new PersonaMedioContacto();
        personaMedioContacto.setId( new PersonaMedioContactoId() );
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public PersonaMedioContacto getPersonaMedioContacto()
    {
        return personaMedioContacto;
    }
}
