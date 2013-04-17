package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("mensajeList")
public class MensajeList extends EntityQuery<Mensaje>
{

    private static final String EJBQL = "select mensaje from Mensaje mensaje";

    private static final String[] RESTRICTIONS = {
        "lower(mensaje.mensaje_1) like lower(concat(#{mensajeList.mensaje.mensaje_1},'%'))",
        "lower(mensaje.asunto) like lower(concat(#{mensajeList.mensaje.asunto},'%'))",
    };

    private Mensaje mensaje = new Mensaje();

    public MensajeList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public Mensaje getMensaje()
    {
        return mensaje;
    }
}
