package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("personaList")
public class PersonaList extends EntityQuery<Persona>
{

    private static final String EJBQL = "select persona from Persona persona";

    private static final String[] RESTRICTIONS = {
        "lower(persona.primerNombre) like lower(concat(#{personaList.persona.primerNombre},'%'))",
        "lower(persona.segundoNombre) like lower(concat(#{personaList.persona.segundoNombre},'%'))",
        "lower(persona.apellidoPaterno) like lower(concat(#{personaList.persona.apellidoPaterno},'%'))",
        "lower(persona.apellidoMaterno) like lower(concat(#{personaList.persona.apellidoMaterno},'%'))",
        "lower(persona.codigo) like lower(concat(#{personaList.persona.codigo},'%'))",
        "lower(persona.usuario) like lower(concat(#{personaList.persona.usuario},'%'))",
        "lower(persona.password) like lower(concat(#{personaList.persona.password},'%'))",
    };

    private Persona persona = new Persona();

    public PersonaList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Persona getPersona()
    {
        return persona;
    }
}
